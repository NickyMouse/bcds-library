package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.Integral;
import com.alibaba.intl.bcds.goldroom.dataobject.IntegralQuery;

/**
 * 
 * @author Larry Su
 */
public interface IntegralDao {
	Integral findById(Integer id);
	
	Integral findByLoginId(String loginId);

	List<Integral> listAll();

	Integer insert(IntegralQuery integralQuery);

	int updateById(IntegralQuery integralQuery);

	int deleteById(Integer id);

	boolean increaseIntegral(String loginId, long integralValue);

	boolean decreaseIntegral(String loginId, long integralValue);
}
