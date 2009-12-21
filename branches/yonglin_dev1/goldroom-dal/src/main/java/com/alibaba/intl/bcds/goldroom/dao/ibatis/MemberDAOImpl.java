package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dao.MemberDAO;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.ibatis.sqlmap.client.SqlMapExecutor;

@SuppressWarnings("unchecked")
public class MemberDAOImpl extends SqlMapClientDaoSupport implements MemberDAO {

	@Override
	public List<Member> listMemberByLoginIds(List<Integer> loginIds)
			throws SQLException {
		if (loginIds == null || loginIds.size() == 0) {
			return new ArrayList<Member>(0);
		}
		HashMap map = new HashMap();
		map.put("loginIdsList", loginIds);
		return getSqlMapClientTemplate().queryForList(
				"MEMBER.listMemberByLoginIds", map);
	}

	public Integer updateByLoginIds(final List<Member> members) {
		return (Integer) getSqlMapClientTemplate().execute(
				new SqlMapClientCallback() {

					@Override
					public Object doInSqlMapClient(SqlMapExecutor executor)
							throws SQLException {
						for (Member member : members) {
							executor.update("MEMBER.updateByLoginId", member);
						}
						return members.size();
					}
				});

	}

	@Override
	public Member selectByLoginId(String loginId) {
		return (Member) getSqlMapClientTemplate().queryForObject(
				"MEMBER.selectByLoginId", loginId);
	}

	@Override
	public Integer insert(Member member) {
		return (Integer) getSqlMapClientTemplate().insert("MEMBER.insert",
				member);
	}

	@Override
	public List<Member> listMemberByStatus(Integer status) {
		return getSqlMapClientTemplate().queryForList(
				"MEMBER.listMemberByStatus", status);
	}

	@Override
	public List<Member> listMemberByIds(List<Integer> ids) throws SQLException {
		HashMap map = new HashMap();
		map.put("idList", ids);
		return getSqlMapClientTemplate().queryForList("MEMBER.listMemberByIds",
				map);
	}

	@Override
	public int updateUserInfoByLoginId(Member member) {;
		return getSqlMapClientTemplate().update("MEMBER.updateUserInfoByLoginId",
				member);
	}
	
	public Map<String, Member> listMemberInfo(){
		return getSqlMapClientTemplate().queryForMap("MEMBER.listMemberInfo",null,"loginId");
	}
}
