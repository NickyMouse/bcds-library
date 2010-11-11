/**
 * 
 */
package com.alibaba.intl.bcds.goldroom.search.commons;

import java.util.Map;

import org.apache.log4j.Logger;
import org.compass.gps.device.hibernate.HibernateGpsDevice;

/**
 * @author Harrison
 * 
 */
public class TestHibernateGpsDevice extends HibernateGpsDevice {
	private static Logger logger = Logger
			.getLogger(TestHibernateGpsDevice.class);
	private Map<String, String> entityQueryMap;

	public void initSelectQuery() {
		if (entityQueryMap != null) {
			for (String key : entityQueryMap.keySet()) {
				if (logger.isDebugEnabled()) {
					logger.debug("selectQuery added: key=" + key + ",  value="
							+ entityQueryMap.get(key));
				}
				this.setIndexSelectQuery(key, entityQueryMap.get(key));
			}
		}
	}

	public void setEntityQueryMap(Map<String, String> entityQueryMap) {
		this.entityQueryMap = entityQueryMap;
	}

	public Map<String, String> getEntityQueryMap() {
		return entityQueryMap;
	}
}
