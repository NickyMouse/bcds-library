package com.alibaba.intl.bcds.goldroom.mail.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.mail.dataobject.LendingWithExpireDays;
import com.alibaba.intl.goldroom.dataobject.BookInfo;
import com.alibaba.intl.goldroom.dataobject.Member;

public interface MailDao {

    public BookInfo getBookInfoById(Integer id);

    public Member getMemberByLoginId(String memberId);

    /**
     * 根据条件查找出借阅记录
     * 
     * @param isExpire 借阅是否过期，当isExpire为真，返回的都是过期的记录；否则都是未过期的
     * @param skipResult
     * @param number
     * @return
     */
    List<LendingWithExpireDays> listLendingWithExpireDays(boolean isExpire, int skipResult, int pageSize);
}
