package com.alibaba.intl.bcds.goldroom.mail.dao.ibatis;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.mail.dao.MailDao;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.LendingWithExpireDays;
import com.alibaba.intl.goldroom.dataobject.BookInfo;
import com.alibaba.intl.goldroom.dataobject.Member;

public class MailDaoImpl extends SqlMapClientDaoSupport implements MailDao {

    @Override
    public BookInfo getBookInfoById(Integer id) {
        if (id != null) {
            return (BookInfo) getSqlMapClientTemplate().queryForObject("findBookInfoById", id);
        } else {
            return null;
        }
    }

    @Override
    public Member getMemberByLoginId(String memberId) {
        if (StringUtils.isNotBlank(memberId)) {
            return (Member) getSqlMapClientTemplate().queryForObject("selectMemberByLoginId", memberId);
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<LendingWithExpireDays> listLendingWithExpireDays(boolean isExpire, int skipResult, int pageSize) {
        Map param = new Hashtable();
        if (!isExpire) {
            param.put("littleThan0", true);
        }
        param.put("skipRows", skipResult);
        param.put("pageSize", pageSize);
        return getSqlMapClientTemplate().queryForList("listLendingWithExpireDays", param);
    }

}
