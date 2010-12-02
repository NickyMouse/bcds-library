package com.alibaba.intl.bcds.goldroom.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.mortbay.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.constaints.MemberEnableEnum;
import com.alibaba.intl.bcds.goldroom.constaints.RoleEnum;
import com.alibaba.intl.bcds.goldroom.dao.MemberDao;
import com.alibaba.intl.bcds.goldroom.dataobject.AlibabaStaffDTO;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dataobject.UserDTO;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.EmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;
import com.alibaba.intl.bcds.goldroom.mail.service.SendMailService;
import com.alibaba.intl.bcds.goldroom.util.MD5;
import com.alibaba.intl.bcds.goldroom.util.PasswordGenerator;
import com.opensymphony.xwork2.ActionContext;

@Transactional
public class MemberService {

    private static Logger   logger = Logger.getLogger(MemberService.class);

    @Autowired
    private MemberDao       memberDao;

    @Autowired
    private SendMailService sendMailService;
    
    @Autowired
    private IntranetService intranetService;

    // @Autowired
    // private MemberLogDao memberLogDao;

    public List<Member> listMemberByLoginIds(List<String> ids) {
        return memberDao.listMemberByLoginIds(ids);
    }

    public Member findMemberByLoginId(String loginId) {
        return memberDao.findByLoginId(loginId);
    }
    
    public Member findMemberByEmail(String email){
    	if(StringUtils.isNotBlank(email)){
    		return memberDao.findByEmail(email);
    	}else
    		return null;
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
    	if(member == null || !StringUtils.isNotBlank(member.getLoginId())){
    		logger.debug("member object is null ....");
    		return null;
    	}
    	
        Member m = memberDao.findByLoginId(member.getLoginId().trim());
        if (m != null) {
            logger.info("[New Member Apply Failed: loginId already exist]" + member.getLoginId());
            return null;
        }
        member.setLoginId(member.getLoginId().trim());
        member.setEnable(MemberEnableEnum.NEW.getValue());
        member.setPassword(MD5.getMD5(member.getPassword()));
        member.setRole(RoleEnum.ROLE_USER.getName());
        member.setEnable(MemberEnableEnum.APPROVE.getValue());
        member.setScore(100); //initial member score to 100 , by Harrison 
        
        // send mail 
        EmailInfo emailInfo = new EmailInfo(ServiceType.ACCOUNT_APPROVED);
        emailInfo.setOwner(member);
        emailInfo.addReceiverEmail(member.getEmail());
        sendMailService.sendVelocityMail(emailInfo, null, null, null,null);
        memberDao.save(member);

        logger.info("[New Member Apply]" + member.getLoginId() + " and sent the mail: " + member.getEmail());
        return member;
    }

    public boolean approveMember(String loginId) {
        Member member = memberDao.findByLoginId(loginId);
        if (member == null) {
            logger.info("[Approve Member Failed: Can not found member]" + loginId);
            return false;
        }
        processApproveMember(member);
        return true;
    }

	private void processApproveMember(Member member) {
		if(member != null){
			member.setEnable(MemberEnableEnum.APPROVE.getValue());
	        member.setScore(100); //initial member score to 100 , by Harrison 
	        memberDao.updateMemberByLoginId(member);
	
	        // send mail
	        EmailInfo emailInfo = new EmailInfo(ServiceType.ACCOUNT_APPROVED);
	        emailInfo.setOwner(member);
	        emailInfo.addReceiverEmail(member.getEmail());
	        sendMailService.sendVelocityMail(emailInfo, null, null, null,null);
	
	        logger.info("[Approve Member success]" + member.getLoginId());
		}
	}

    /**
     * 根据Email地址自动查询ali内网进行会员信息注册，同时自动进行approve操作
     * @param email
     * @return
     * @author Harrison
     */
    public Member autoRegistByEmail(String email){
    	Member regMember = null;
    	if(StringUtils.isNotBlank(email)){
    		AlibabaStaffDTO staff = intranetService.getUserInfoByEmail(email);
    		if(staff != null){
    			Member member = new Member();
    			if(StringUtils.isNotBlank(staff.getAliTalkId()))member.setAliTalkId(staff.getAliTalkId());
    			if(StringUtils.isNotBlank(staff.getStaffId()))member.setWorkId(Integer.valueOf(staff.getStaffId()));
    			if(StringUtils.isNotBlank(staff.getExtPhone()))member.setExt(staff.getExtPhone());
    			
    			member.setLoginId((StringUtils.isNotBlank(staff.getNick()))?staff.getNick().toLowerCase():staff.getName());
    			member.setPassword("hello1234");
    			member.setName(staff.getName());
    			member.setEmail(staff.getEmail());
    			
    			regMember = applyMember(member);
    			boolean t = false;
    			if(regMember != null && StringUtils.isNotBlank(regMember.getLoginId())){
    				t = approveMember(regMember.getLoginId());
    			}
    			logger.info(" user auto registed result : " + (t==true?" success ":" failure ") + " with email: " + (StringUtils.isNotBlank(staff.getEmail())?staff.getEmail():" null ") + " and staffId: " + (StringUtils.isNotBlank(staff.getStaffId())?staff.getStaffId():" null"));
    		}else{
    			logger.error(" can not obtain the original staff info with email: " + email);
    		}
    	}
    	return regMember;
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

    /**
     * 用户登录
     * @param loginId
     * @param password
     * @return member 对象
     */
    public UserDTO doLogin(String loginId, String password) {
        if (StringUtils.isEmpty(loginId) || StringUtils.isEmpty(password)) {
            return null;
        }
        Member m = memberDao.findByLoginId(loginId);
        if (m == null || !loginId.equals(m.getLoginId()) || !MemberEnableEnum.APPROVE.getValue().equals(m.getEnable())) {
            return null;
        }
        if (MD5.getMD5(password).equals(m.getPassword())) {
        	//登录成功
        	UserDTO userDto = new UserDTO();
            userDto.setId(m.getId());
            userDto.setUserName(m.getName());
            userDto.setScore(m.getScore());
            userDto.setLoginId(m.getLoginId());
        	ActionContext.getContext().getSession().put(UserDTO.MEMBER_LOGGED_SESSION_KEY, userDto);
            return userDto;
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
    
    /**
     * 按照积分排行获取用户列表
     * @param count 数量
     * @return
     */
    public List<Member> listMemberByScore(int count) {
    	
    	return memberDao.listMemberByScore(count);
    }

	/**
	 * @return the memberDao
	 */
	public MemberDao getMemberDao() {
		return memberDao;
	}

	/**
	 * @param memberDao the memberDao to set
	 */
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	/**
	 * @return the sendMailService
	 */
	public SendMailService getSendMailService() {
		return sendMailService;
	}

	/**
	 * @param sendMailService the sendMailService to set
	 */
	public void setSendMailService(SendMailService sendMailService) {
		this.sendMailService = sendMailService;
	}

	/**
	 * @return the intranetService
	 */
	public IntranetService getIntranetService() {
		return intranetService;
	}

	/**
	 * @param intranetService the intranetService to set
	 */
	public void setIntranetService(IntranetService intranetService) {
		this.intranetService = intranetService;
	}
}
