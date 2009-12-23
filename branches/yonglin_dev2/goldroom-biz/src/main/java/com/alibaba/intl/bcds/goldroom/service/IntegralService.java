package com.alibaba.intl.bcds.goldroom.service;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.Integral;
import com.alibaba.intl.bcds.goldroom.dataobject.IntegralQuery;

/**
 * IntegralService 积分服务
 * 
 * @author Larry Su
 */
public interface IntegralService {
	
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
     * 根据Id查询积分
     * 
     * @param id 积分记录编号
     * @return 查询的结果对象
     */
	Integral findById(Integer id);

    /**
     * 根据LoginId查询积分
     * 
     * @param loginId 用户登录Id
     * @return 查询的结果对象
     */
	Integral findByLoginId(String loginId);

    /**
     * 插入新的积分记录
     * 
     * @param integralQuery 条件对象
     * @return 查询的结果对象
     */
	int insert(IntegralQuery integralQuery);

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
     * @param loginId 用户登录Id
     * @param integralValue 增加积分值
     * @return 是否更新成功
     */
	boolean increaseIntegral(String loginId, long integralValue);

    /**
     * 减少积分
     * 
     * @param loginId 登录Id
     * @param integralValue 减少积分值
     * @return 是否更新成功
     */
	boolean decreaseIntegral(String loginId, long integralValue);
	
}
