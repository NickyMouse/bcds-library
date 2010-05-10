package com.alibaba.intl.goldroom.dao.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.alibaba.intl.goldroom.dataobject.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations = { "classpath:/META-INF/dispatcherServlet-servlet.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class MemberDaoImplTest extends TestCase {

    @Autowired
    MemberDaoImpl memberDao;

    @Test
    public void testMemberDao() {
        Member m = memberDao.findByLoginId("gangyi.xiaogy");
        assertNotNull(m);
    }

    @Test
    public void testListMemberByLoginIds() {
        List<String> ids = new ArrayList<String>();
        ids.add("gangyi.xiaogy");
        ids.add("admin");

        List<Member> members = memberDao.listMemberByLoginIds(ids);
        for (Member m : members) {
            System.out.println(m.getName());
        }
    }

    // @Test
    // public void testUpdateMemberByLoginId() {
    // Member m = new Member();
    // m.setLoginId("kaka");
    // m.setName("hihi");
    // m.setWorkId(123333);
    // memberDao.updateMemberByLoginId(m);
    // }

    @Test
    public void testUpdatePasswordByLoginId() {
        String password = "29cffb33dbada1464a5b2df9b88ffe09";
        memberDao.updatePasswordByLoginId("gangyi.xiaogy", password);
        Member m = memberDao.findByLoginId("gangyi.xiaogy");
        assertEquals(m.getPassword(), password);
    }

    @Test
    public void testSave() {
        Member m = new Member();
        m.setEmail("hello@125.com");
        m.setName("hello@125.com");
        m.setLoginId("hello");
        m.setId(106);
        memberDao.save(m);
//       assertNotNull(memberDao.findByLoginId("hello"));
    }
}
