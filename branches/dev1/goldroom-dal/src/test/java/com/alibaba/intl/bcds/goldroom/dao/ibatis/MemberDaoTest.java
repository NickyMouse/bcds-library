package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.alibaba.intl.bcds.goldroom.dao.test.BaseTest;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;

@TransactionConfiguration(defaultRollback = true)
public class MemberDaoTest extends BaseTest {

    @Autowired
    private MemberDAOImpl memberDAOImpl;

    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testListByIds() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        try {
            List<Member> result = memberDAOImpl.listMemberByLoginIds(list);
            for (Member m : result) {
                System.out.println(m.getName());
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
