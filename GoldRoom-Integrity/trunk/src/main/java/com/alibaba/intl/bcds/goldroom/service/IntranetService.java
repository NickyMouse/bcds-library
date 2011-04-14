/**
 *
 */
package com.alibaba.intl.bcds.goldroom.service;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.intl.bcds.goldroom.dataobject.AlibabaStaffDTO;

/**
 * @author Harrison
 *
 */
public class IntranetService {

	public static final String INTRANET_USER = "aliresume";
	public static final String INTRANET_PASS = "1C3033A82169A15F4825777E0036B10E";
	private String socksProxyHost;
	private String socksProxyPort;

	private final Logger log = Logger.getLogger(IntranetService.class);

	public void init() {
		if (StringUtils.isNotBlank(socksProxyHost)
				&& StringUtils.isNotBlank(socksProxyPort)) {
			System.setProperty("socksProxyHost", socksProxyHost);
			System.setProperty("socksProxyPort", socksProxyPort);
		}
	}

	/**
	 * 获取员工信息
	 *
	 * @param strEmail
	 * @param systemid
	 * @param password
	 * @return
	 */
	public AlibabaStaffDTO getUserInfoByEmail(String strEmail) {

		try {
			final String endpoint = "http://service.cn.alibaba-inc.com:80/service/webservice.nsf/GetUserVerifyByEmail?WSDL";
			Service service = new Service();
			Call call = null;
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(endpoint));
			call.setOperationName("GetUserVerifyByEmail");

			String[] result = (String[]) call.invoke(new Object[] { strEmail,
					IntranetService.INTRANET_USER,
					IntranetService.INTRANET_PASS });

			log.info(" obtained the staff info , name: " + result[1]
					+ " staffId:" + result[0]);

			AlibabaStaffDTO aliStaff = new AlibabaStaffDTO();
			aliStaff.setStaffId(result[0]);
			aliStaff.setName(result[1]);
			aliStaff.setNick(result[2]);
			aliStaff.setGendear(result[3]);
			aliStaff.setDepartment(result[4]);
			aliStaff.setTitle(result[5]);
			aliStaff.setExtPhone(result[6]);
			aliStaff.setMobile(result[7]);
			aliStaff.setEmail(result[8]);
			aliStaff.setAliTalkId(result[9]);

			return aliStaff;
		} catch (Exception e) {
			log.error(" get user info error ~!", e);
		}
		return null;
	}

	public void setSocksProxyHost(String socksProxyHost) {
		this.socksProxyHost = socksProxyHost;
	}

	public String getSocksProxyHost() {
		return socksProxyHost;
	}

	public void setSocksProxyPort(String socksProxyPort) {
		this.socksProxyPort = socksProxyPort;
	}

	public String getSocksProxyPort() {
		return socksProxyPort;
	}
}
