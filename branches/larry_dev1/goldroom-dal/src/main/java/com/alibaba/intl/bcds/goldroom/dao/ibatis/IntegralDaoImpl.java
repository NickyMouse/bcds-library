package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dao.IntegralDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Integral;
import com.alibaba.intl.bcds.goldroom.dataobject.IntegralQuery;

/**
 * 
 * @author Larry Su
 */
public class IntegralDaoImpl extends SqlMapClientDaoSupport implements
		IntegralDao {

	@SuppressWarnings("unchecked")
	public List<Integral> listByQuery(IntegralQuery integralQuery) {
		return getSqlMapClientTemplate().queryForList("INTEGRAL.listByQuery",
				integralQuery);
	}

	@SuppressWarnings("unchecked")
	public List<Integral> listAll() {
		return getSqlMapClientTemplate().queryForList("INTEGRAL.listAll");
	}

	public Integer insert(IntegralQuery integralQuery) {
		return (Integer) getSqlMapClientTemplate().insert("INTEGRAL.insert",
				integralQuery);
	}

	public int updateById(IntegralQuery integralQuery) {
		return getSqlMapClientTemplate().update("INTEGRAL.updateById",
				integralQuery);
	}

	public int deleteById(Integer id) {
		return getSqlMapClientTemplate().delete("INTEGRAL.deleteById", id);
	}

	public int increaseIntegral(IntegralQuery integralQuery) {
		return getSqlMapClientTemplate().update("INTEGRAL.increase",
				integralQuery);
	}

	public int decreaseIntegral(IntegralQuery integralQuery) {
		return getSqlMapClientTemplate().update("INTEGRAL.decrease",
				integralQuery);
	}

}
