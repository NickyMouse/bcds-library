package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dao.IntegralDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Integral;
import com.alibaba.intl.bcds.goldroom.dataobject.IntegralQuery;

/**
 * 积分DAO实现类
 * 
 * @author Larry Su
 */
public class IntegralDaoImpl extends SqlMapClientDaoSupport implements
		IntegralDao {
	
    /**
     * 查询所有积分列表
     * 
     */
	@SuppressWarnings("unchecked")
	public List<Integral> listAll() {
		return getSqlMapClientTemplate().queryForList("INTEGRAL.listAll");
	}

	/**
	 * 根据条件查询积分列表
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Integral> listByQuery(IntegralQuery integralQuery) {
		return getSqlMapClientTemplate().queryForList("INTEGRAL.listByQuery",
				integralQuery);
	}

	/**
	 * 插入新的积分记录
	 * 
	 */
	public int insert(IntegralQuery integralQuery) {
		return (Integer) getSqlMapClientTemplate().insert("INTEGRAL.insert",
				integralQuery);
	}

	/**
	 * 修改积分记录
	 * 
	 */
	public int updateById(IntegralQuery integralQuery) {
		return getSqlMapClientTemplate().update("INTEGRAL.updateById",
				integralQuery);
	}

	/**
	 * 根据Id删除积分记录
	 * 
	 */
	public int deleteById(Integer id) {
		return getSqlMapClientTemplate().delete("INTEGRAL.deleteById", id);
	}
	
	/**
	 * 增加积分
	 * 
	 */
	public int increaseIntegral(IntegralQuery integralQuery) {
		return getSqlMapClientTemplate().update("INTEGRAL.increase",
				integralQuery);
	}

	/**
	 * 减少积分
	 * 
	 */
	public int decreaseIntegral(IntegralQuery integralQuery) {
		return getSqlMapClientTemplate().update("INTEGRAL.decrease",
				integralQuery);
	}

}
