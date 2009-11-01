package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.intl.bcds.goldroom.dao.test.BaseTest;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;

public class MemberDaoImplTestCase extends BaseTest {
	@Autowired
	private MemberDAOImpl memberDAOImpl;

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
