package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.Integral;
import com.alibaba.intl.bcds.goldroom.dataobject.IntegralQuery;

/**
 * 积分DAO
 * 
 * @author Larry Su
 */
public interface IntegralDao {
	
    /**
     * 查询所有积分列表
     * 
     * @return 查询结果集合
     */
	List<Integral> listAll();
	
    /**
     * 根据条件查询积分列表
     * 
     * @param integralQuery 条件对象
     * @return 查询结果集合
     */
	List<Integral> listByQuery(IntegralQuery integralQuery);

    /**
     * 插入新的积分记录
     * 
     * @param integralQuery 条件对象
     * @return 查询的结果对象
     */
	Integer insert(IntegralQuery integralQuery);

    /**
     * 修改积分记录
     * 
     * @param integralQuery 条件对象
     * @return 修改记录总数
     */
	int updateById(IntegralQuery integralQuery);

    /**
     * 根据Id删除积分记录
     * 
     * @param id 积分记录编号
     * @return 删除记录总数
     */
	int deleteById(Integer id);

    /**
     * 增加积分
     * 
     * @param integralQuery 条件对象
     * @return 是否更新成功
     */
	int decreaseIntegral(IntegralQuery integralQuery);
	
    /**
     * 减少积分
     * 
     * @param integralQuery 条件对象
     * @return 是否更新成功
     */
	int increaseIntegral(IntegralQuery integralQuery);
}
