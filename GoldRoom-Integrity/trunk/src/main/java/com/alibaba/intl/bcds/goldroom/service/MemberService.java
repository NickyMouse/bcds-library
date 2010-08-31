package com.alibaba.intl.bcds.goldroom.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.constaints.MemberEnableEnum;
import com.alibaba.intl.bcds.goldroom.constaints.RoleEnum;
import com.alibaba.intl.bcds.goldroom.dao.MemberDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.EmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;
import com.alibaba.intl.bcds.goldroom.mail.service.SendMailService;
import com.alibaba.intl.bcds.goldroom.util.MD5;
import com.alibaba.intl.bcds.goldroom.util.PasswordGenerator;

@Transactional
public class MemberService {

    private static Logger   logger = Logger.getLogger(MemberService.class);

    @Autowired
    private MemberDao       memberDao;

    @Autowired
    private SendMailService sendMailService;

    // @Autowired
    // private MemberLogDao memberLogDao;

    public List<Member> listMemberByLoginIds(List<String> ids) {
        return memberDao.listMemberByLoginIds(ids);
    }

    public Member findMemberByLoginId(String loginId) {
        return memberDao.findByLoginId(loginId);
    }

    public boolean isLoginIdExist(String loginId) {
        if (StringUtils.isBlank(loginId)) {
            return false;
        }
        Member m = memberDao.findByLoginId(loginId);
        if (m == null) {
            return false;
        } else {
            return true;
        }
    }

    public Member applyMember(Member member) {
        Member m = memberDao.findByLoginId(member.getLoginId().trim());
        if (m != null) {
            logger.info("[New Member Apply Failed: loginId already exist]" + member.getLoginId());
            return null;
        }
        member.setLoginId(member.getLoginId().trim());
        member.setEnable(MemberEnableEnum.NEW.getValue());
        member.setPassword(MD5.getMD5(member.getPassword()));
        member.setRole(RoleEnum.ROLE_USER.getName());
        logger.info("[New Member Apply]" + member.getLoginId());
        return memberDao.save(member);

        // MemberLog log = new MemberLog();
        // log.setMemberId(memberId);
        // log.setLogMsg("apply");
        // log.setLogType(MemberLogType.APPLY.getIntValue());
        // memberLogDao.insert(log);

    }

    public boolean approveMember(String loginId) {
        Member member = memberDao.findByLoginId(loginId);
        if (member == null) {
            logger.info("[Approve Member Failed: Can not found member]" + loginId);
            return false;
        }
        member.setEnable(MemberEnableEnum.APPROVE.getValue());
        member.setScore(100); //initial member score to 100 , by Harrison 
        memberDao.updateMemberByLoginId(member);

        // send mail
        EmailInfo emailInfo = new EmailInfo(ServiceType.ACCOUNT_APPROVED);
        emailInfo.setOwner(member);
        emailInfo.addReceiverEmail(member.getEmail());
        sendMailService.sendVelocityMail(emailInfo, null, null, null,null);

        logger.info("[Approve Member success]" + loginId);
        return true;
    }

    public boolean tbdMembers(String loginId) {
        Member member = memberDao.findByLoginId(loginId);
        if (member == null) {
            logger.info("[TBD Member Failed: Can not found member]" + loginId);
            return false;
        }
        member.setEnable(MemberEnableEnum.TBD.getValue());
        memberDao.updateMemberByLoginId(member);

        EmailInfo emailInfo = new EmailInfo(ServiceType.ACCOUNT_TBD);
        emailInfo.setOwner(member);
        emailInfo.addReceiverEmail(member.getEmail());
        sendMailService.sendVelocityMail(emailInfo, null, null, null,null);

        logger.info("[TBD Member success]" + loginId);
        return true;
    }

    public boolean updateMemberByLoginId(Member member) {
        return memberDao.updateMemberByLoginId(member);
    }

    public boolean changePassword(String loginId, String oldPassword, String newPassword) {
        Member m = memberDao.findByLoginId(loginId);
        if (m == null) {
            return false;
        }
        oldPassword = MD5.getMD5(oldPassword);
        newPassword = MD5.getMD5(newPassword);
        if (m.getPassword().equals(oldPassword)) {
            return memberDao.updatePasswordByLoginId(loginId, newPassword);
        } else {
            return false;
        }
    }

    public Member login(String loginId, String password) {
        if (StringUtils.isEmpty(loginId) || StringUtils.isEmpty(password)) {
            return null;
        }
        Member m = memberDao.findByLoginId(loginId);
        if (m == null || !loginId.equals(m.getLoginId()) || !MemberEnableEnum.APPROVE.getValue().equals(m.getEnable())) {
            return null;
        }
        if (MD5.getMD5(password).equals(m.getPassword())) {
            return m;
        } else {
            return null;
        }
    }

    public List<Member> listMemberByStatus(String status) {
        if (StringUtils.isEmpty(status)) {
            return null;
        } else {
            return memberDao.listMemberByStatus(MemberEnableEnum.getMemberEnableEnum(status).getValue());
        }
    }

    public boolean forgetPassword(String name, String email) {
        Member m = memberDao.findByNameAndEmail(name, email);
        if (m == null || !MemberEnableEnum.APPROVE.getValue().equals(m.getEnable())) {
            return false;
        }
        String password = PasswordGenerator.getRandomPassword();
        m.setPassword(password);
        EmailInfo emailInfo = new EmailInfo(ServiceType.FORGET_PASSWORD);
        emailInfo.setOwner(m);
        emailInfo.addReceiverEmail(m.getEmail());
        sendMailService.sendVelocityMail(emailInfo, null, null, null,null);
        memberDao.updatePasswordByLoginId(m.getLoginId(), MD5.getMD5(password));
        return true;
    }
}
