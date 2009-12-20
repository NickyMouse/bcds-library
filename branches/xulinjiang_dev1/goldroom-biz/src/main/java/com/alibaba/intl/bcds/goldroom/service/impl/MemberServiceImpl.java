package com.alibaba.intl.bcds.goldroom.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.constants.MemberEnableEnum;
import com.alibaba.intl.bcds.goldroom.constants.MemberLogType;
import com.alibaba.intl.bcds.goldroom.constants.RoleEnum;
import com.alibaba.intl.bcds.goldroom.dao.MemberDAO;
import com.alibaba.intl.bcds.goldroom.dao.MemberLogDAO;
import com.alibaba.intl.bcds.goldroom.dao.MemberRoleDAO;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dataobject.MemberLog;
import com.alibaba.intl.bcds.goldroom.dataobject.MemberRole;
import com.alibaba.intl.bcds.goldroom.dto.MemberDTO;
import com.alibaba.intl.bcds.goldroom.exception.LoginIdDuplicatedException;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.AccountApprovedEmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.service.SendMailService;
import com.alibaba.intl.bcds.goldroom.service.MemberService;
import com.alibaba.intl.bcds.goldroom.service.result.Result;

@Transactional
public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;
	private MemberLogDAO memberLogDAO;
	private MemberRoleDAO memberRoleDAO;
	private SendMailService sendMailService;
	

	public void setSendMailService(SendMailService sendMailService) {
		this.sendMailService = sendMailService;
	}

	@Override
	public List<Member> listMemberByLoginIds(List<Integer> ids) {
		try {
			return memberDAO.listMemberByLoginIds(ids);
		} catch (SQLException e) {
			return new ArrayList<Member>();
		}
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void setMemberLogDAO(MemberLogDAO memberLogDAO) {
		this.memberLogDAO = memberLogDAO;
	}

	public void setMemberRoleDAO(MemberRoleDAO memberRoleDAO) {
		this.memberRoleDAO = memberRoleDAO;
	}

	@Override
	public Result applyMember(Member member) {
		try {
			Member m = memberDAO.selectByLoginId(member.getLoginId());
			if (m != null) {
				throw new LoginIdDuplicatedException("loginId duplicated");
			}
			member.setEnable(MemberEnableEnum.NEW.getValue());
			Integer memberId = this.memberDAO.insert(member);
			MemberRole memberRole = new MemberRole();
			memberRole.setMemberId(memberId);
			memberRole.setRoleId(RoleEnum.ROLE_USER.getId());
			memberRoleDAO.insert(memberRole);
			MemberLog log = new MemberLog();
			log.setMemberId(memberId);
			log.setLogMsg("apply");
			log.setLogType(MemberLogType.APPLY.getIntValue());
			memberLogDAO.insert(log);
			return Result.SUCCESS;
		} catch (Exception e) {
			return new Result(false);
		}

	}

	@Override
	public Result approveMembers(List<Integer> ids) {
		try {
			List<Member> members = memberDAO.listMemberByIds(ids);
			for (Member member : members) {
				member.setEnable(MemberEnableEnum.APPROVE.getValue());
				//发送通知邮件
				AccountApprovedEmailInfo emailInfo = new AccountApprovedEmailInfo(member);
				sendMailService.sendMail(emailInfo);
			}
			memberDAO.updateByLoginIds(members);

			return Result.SUCCESS;
		} catch (Exception e) {
			return new Result(false);
		}
	}

	@Override
	public Result tbdMembers(List<Integer> ids) {
		try {
			List<Member> members = memberDAO.listMemberByIds(ids);
			for (Member member : members) {
				member.setEnable(MemberEnableEnum.TBD.getValue());
			}
			memberDAO.updateByLoginIds(members);
			return Result.SUCCESS;
		} catch (Exception e) {
			return new Result(false);
		}
	}

	@Override
	public List<MemberDTO> listMemberByStatus(MemberEnableEnum memberEnable) {
		List<MemberDTO> retList = new ArrayList<MemberDTO>();
		List<Member> members = memberDAO.listMemberByStatus(memberEnable
				.getValue());
		List<Integer> memberIds = new ArrayList<Integer>();
		for (Member member : members) {
			memberIds.add(member.getId());
		}
		Map<Integer, MemberRole> roleMap = memberRoleDAO
				.mapMemberRoleByMemberIds(memberIds);
		for (Member member : members) {
			retList.add(new MemberDTO(member, roleMap.get(member.getId())));
		}
		return retList;
	}

	@Override
	public Result updateUserInfoByLoginId(Member member) {
		if (memberDAO.updateUserInfoByLoginId(member) > 0) {
			return Result.SUCCESS;
		} else {
			return new Result(false);
		}
	}

}
