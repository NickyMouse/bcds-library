package com.alibaba.intl.bcds.goldroom.service;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.constants.MemberEnableEnum;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dto.MemberDTO;
import com.alibaba.intl.bcds.goldroom.service.result.Result;

public interface MemberService {

    List<Member> listMemberByLoginIds(List<Integer> ids);

    /**
     * 申请会员
     * 
     * @param member
     * @return
     */
    Result applyMember(Member member);

    /**
     * 审核通过
     * 
     * @param ids
     * @return
     */
    Result approveMembers(List<Integer> ids);
    
    /**
     * TBD 用户
     * @param ids
     * @return
     */
    Result tbdMembers(List<Integer> ids);

    /**
     * 根据会员状态来获取所有会员
     * 
     * @param memberEnable
     * @return
     */
    List<MemberDTO> listMemberByStatus(MemberEnableEnum memberEnable);
    
    /**
     * 根据loginId修改用户密码
     * @param loginId
     * @param oldPassword
     * @param newPassword
     * @return
     */
    Result changePasswordByLoginId(String loginId, String newPassword);
}
