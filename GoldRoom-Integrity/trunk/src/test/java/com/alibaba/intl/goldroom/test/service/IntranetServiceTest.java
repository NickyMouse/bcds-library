package com.alibaba.intl.goldroom.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.intl.bcds.goldroom.dataobject.AlibabaStaffDTO;
import com.alibaba.intl.bcds.goldroom.service.IntranetService;
import com.alibaba.intl.goldroom.test.SpringAbstractIntegrationTestcaseBase;

public class IntranetServiceTest extends SpringAbstractIntegrationTestcaseBase{


	@Autowired
	private IntranetService intranetService;
	
	@Test
	public void testServiceInjection(){
		Assert.assertNotNull(intranetService);
		AlibabaStaffDTO harrison = intranetService.getUserInfoByEmail("harrison.yaog@alibaba-inc.com");
		Assert.assertNotNull(harrison);
		
		AlibabaStaffDTO hatter = intranetService.getUserInfoByEmail("haitao.jianght@alibaba-inc.com");
		Assert.assertNotNull(hatter);
		Assert.assertTrue(hatter.getExtPhone().equals("30817"));
		Assert.assertTrue(hatter.getName().equals("蒋海滔"));
		
		AlibabaStaffDTO chunmei = intranetService.getUserInfoByEmail("chunmei.tancm@alibaba-inc.com");
		Assert.assertNotNull(chunmei);
	}
}
