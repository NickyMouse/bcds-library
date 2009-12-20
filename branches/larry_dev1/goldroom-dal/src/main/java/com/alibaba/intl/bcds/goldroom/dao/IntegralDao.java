package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.Integral;
import com.alibaba.intl.bcds.goldroom.dataobject.IntegralQuery;

/**
 * 
 * @author Larry Su
 */
public interface IntegralDao {
	
	List<Integral> listByQuery(IntegralQuery integralQuery);

	List<Integral> listAll();

	Integer insert(IntegralQuery integralQuery);

	int updateById(IntegralQuery integralQuery);

	int deleteById(Integer id);

	int increaseIntegral(IntegralQuery integralQuery);

	int decreaseIntegral(IntegralQuery integralQuery);
}
