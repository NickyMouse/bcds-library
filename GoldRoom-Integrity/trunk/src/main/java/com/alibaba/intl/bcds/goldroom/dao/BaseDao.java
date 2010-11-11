/**
 * 
 */
package com.alibaba.intl.bcds.goldroom.dao;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

/**
 * @author Harrison
 *
 */
public abstract class BaseDao extends HibernateDaoSupport{
	
	/**
	 * 创建Criteria对象.
	 *
	 * @param criterions 可变的Restrictions条件列表,见{@link #createQuery(String,Object...)}
	 */
	public <T> Criteria createCriteria(Class<T> entityClass, Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	/**
	 * 创建Query对象. 对于需要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以在返回Query后自行设置.
	 * 留意可以连续设置,如下：
	 * <pre>
	 * dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
	 * </pre>
	 * 调用方式如下：
	 * <pre>
	 *        dao.createQuery(hql)
	 *        dao.createQuery(hql,arg0);
	 *        dao.createQuery(hql,arg0,arg1);
	 *        dao.createQuery(hql,new Object[arg0,arg1,arg2])
	 * </pre>
	 *
	 * @param values 可变参数.
	 */
	public Query createQuery(String hql, Object... values) {
		Assert.hasText(hql);
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}
	
	/**
	 * 根据 NamedQuery 获得Hibernate Query对象，随后可以进行setFetchSize、setMaxResults、等参数的设定 
	 * <pre>
	 * 	query.setFetchSize(10);
	 * 	query.setMaxResult(100);
	 *  query.setFirstResult(20);
	 * </pre>
	 * 
	 * 
	 * @param queryName 命名查询语句，需要实现约定
	 * @return
	 */
	public Query createNamedQuery(String queryName){
		Assert.hasText(queryName);
		Query query = getSession().getNamedQuery(queryName);
		query.setCacheable(true);
		return query;
	}
}

