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

	public static final String INCREASE = "increase";

	public static final String DECREASE = "decrease";

	public Integral findById(Integer id) {
		return (Integral) getSqlMapClientTemplate().queryForObject(
				"INTEGRAL.findById", id);
	}

	public Integral findByLoginId(String loginId) {
		return (Integral) getSqlMapClientTemplate().queryForObject(
				"INTEGRAL.findByLoginId", loginId);
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

	public boolean increaseIntegral(String loginId, long integralValue) {
		return this.creaseIntegral(loginId, integralValue, this.INCREASE);
	}

	public boolean decreaseIntegral(String loginId, long integralValue) {
		return this.creaseIntegral(loginId, integralValue, this.DECREASE);
	}

	private boolean creaseIntegral(String loginId, long integralValue,
			String type) {
		Integral integral = this.findByLoginId(loginId);
		if (integral == null) {
			return false;
		}
		IntegralQuery integralQuery = new IntegralQuery();
		integralQuery.setLoginId(loginId);
		integralQuery.setAlterValue(integralValue);

		int rel = 0;
		if (type != null && type.equalsIgnoreCase(this.INCREASE)) {
			rel = getSqlMapClientTemplate().update("INTEGRAL.increase",
					integralQuery);
		} else if (type != null && type.equalsIgnoreCase(this.DECREASE)) {
			rel = getSqlMapClientTemplate().update("INTEGRAL.decrease",
					integralQuery);
		} else {
			return false;
		}
		if (rel > 0) {
			return true;
		} else {
			return false;
		}
	}
}
