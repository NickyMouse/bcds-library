package com.alibaba.intl.bcds.goldroom.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.commons.lang.StringUtils;

import com.alibaba.intl.bcds.goldroom.dao.IntegralDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Integral;
import com.alibaba.intl.bcds.goldroom.dataobject.IntegralQuery;
import com.alibaba.intl.bcds.goldroom.service.IntegralService;

/**
 * IntegralServiceImpl 积分服务实现
 * 
 * @author Larry Su
 */
public class IntegralServiceImpl implements IntegralService {

	private static Logger logger = Logger.getLogger(IntegralServiceImpl.class);

	private IntegralDao integralDao;

	// 修改积分值类型常量(增加)
	private final String INCREASE = "increase";

	// 修改积分值类型常量(减少)
	private final String DECREASE = "decrease";

	public void setIntegralDao(IntegralDao integralDao) {
		this.integralDao = integralDao;
	}

	public IntegralDao getIntegralDao() {
		if (this.integralDao == null) {
			logger.error("integralDao is null!");
		}
		return this.integralDao;
	}

	/**
	 * 查询所有积分列表
	 * 
	 */
	public List<Integral> listAll() {
		logger.debug("list all integral.");
		return this.getIntegralDao().listAll();
	}

	/**
	 * 根据条件查询积分列表
	 * 
	 */
	public List<Integral> listByQuery(IntegralQuery integralQuery) {
		logger.debug("list integral.");
		return this.getIntegralDao().listByQuery(integralQuery);
	}

	/**
	 * 根据Id查询积分
	 * 
	 */
	public Integral findById(Integer id) {
		logger.debug("find integral : id=" + id);
		// 如果id为空，则直接返回。
		if (id == null) {
			return new Integral();
		}
		List<Integral> integralList = this.getIntegralDao().listByQuery(
				new IntegralQuery(id));
		return this.getIntegral(integralList);
	}

	/**
	 * 根据LoginId查询积分
	 * 
	 */
	public Integral findByLoginId(String loginId) {
		logger.debug("find integral : loginId=" + loginId);
		// 如果loginId为空，则直接返回。
		if (StringUtils.isBlank(loginId)) {
			return new Integral();
		}
		List<Integral> integralList = this.getIntegralDao().listByQuery(
				new IntegralQuery(loginId));
		return this.getIntegral(integralList);
	}

	/**
	 * 插入新的积分记录
	 * 
	 */
	public int insert(IntegralQuery integralQuery) {
		logger.debug("insert integral.");
		return this.getIntegralDao().insert(integralQuery);
	}

	/**
	 * 修改积分记录
	 * 
	 */
	public int updateById(IntegralQuery integralQuery) {
		logger.debug("update integral.");
		return this.getIntegralDao().updateById(integralQuery);
	}

	/**
	 * 根据Id删除积分记录
	 * 
	 */
	public int deleteById(Integer id) {
		logger.debug("delete integral : id=" + id);
		if (id == null) {
			logger.warn("id is null! integral data delete defeated!");
			return 0;
		}
		return this.getIntegralDao().deleteById(id);
	}

	/**
	 * 增加积分
	 * 
	 */
	public boolean increaseIntegral(String loginId, long integralValue) {
		logger.debug("increase integral : loginId=" + loginId
				+ ", integralValue=" + integralValue);
		return this.creaseIntegral(loginId, integralValue, this.INCREASE);
	}

	/**
	 * 减少积分
	 * 
	 * 当减少的积分大于当前用户所拥有的积分时，用户积分将减少到0，不会出现负积分。
	 */
	public boolean decreaseIntegral(String loginId, long integralValue) {
		logger.debug("decrease integral : loginId=" + loginId
				+ ", integralValue=" + integralValue);
		return this.creaseIntegral(loginId, integralValue, this.DECREASE);
	}

	/**
	 * 从积分列表中取得第一条记录
	 * 
	 * @param integralList
	 *            积分列表
	 * @return 第一条记录
	 */
	private Integral getIntegral(List<Integral> integralList) {
		if (integralList != null && integralList.size() > 0) {
			return integralList.get(0);
		} else {
			return new Integral();
		}
	}

	/**
	 * 修改积分值的通用方法
	 * 
	 * @param loginId
	 *            用户登录Id
	 * @param integralValue
	 *            修改的值
	 * @param type
	 *            修改类型(增加&减少)
	 * @return 是否修改成功
	 */
	private boolean creaseIntegral(String loginId, long integralValue,
			String type) {
		// 如果loginId无效，则直接返回false
		if (StringUtils.isBlank(loginId)) {
			return false;
		}
		Integral integral = this.findByLoginId(loginId);
		// 如果不存在该用户的积分记录，则新建一条记录再取一次。
		if (integral.getLoginId() == null) {
			this.getIntegralDao().insert(new IntegralQuery(loginId));
		}

		long value = integral.getValue();
		if (value < 0) {
			return false;
		}

		IntegralQuery integralQuery = new IntegralQuery(loginId);

		int rel = 0;
		if (StringUtils.isNotEmpty(type)
				&& type.equalsIgnoreCase(this.INCREASE)) {
			// 增加积分
			integralQuery.setAlterValue(integralValue);
			rel = this.getIntegralDao().increaseIntegral(integralQuery);
		} else if (StringUtils.isNotEmpty(type)
				&& type.equalsIgnoreCase(this.DECREASE)) {
			// 减少积分
			if (value < integralValue) {
				integralValue = value;
			}
			integralQuery.setAlterValue(integralValue);
			rel = this.getIntegralDao().decreaseIntegral(integralQuery);
		} else {
			return false;
		}
		return rel > 0 ? true : false;

	}

}
