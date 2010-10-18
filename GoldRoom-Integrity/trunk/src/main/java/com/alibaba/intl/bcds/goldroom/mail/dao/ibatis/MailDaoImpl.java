package com.alibaba.intl.bcds.goldroom.mail.dao.ibatis;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.mail.dao.MailDao;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.LendingWithExpireDays;

@SuppressWarnings("unchecked")
public class MailDaoImpl implements MailDao {

	@PersistenceContext(unitName = "goldroomPU")
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<LendingWithExpireDays> listLendingWithExpireDays(boolean isExpire, int skipResult, int pageSize) {
    	//TODO enable the LendingWithExpireDays entity and obtained the data
        Map param = new Hashtable<String,Object>();
        if (!isExpire) {
            param.put("littleThan0", true);
        }
        param.put("skipRows", skipResult);
        param.put("pageSize", pageSize);
       // return getSqlMapClientTemplate().queryForList("listLendingWithExpireDays", param);
       //TODO obtain the data
        return null;
    }

}
