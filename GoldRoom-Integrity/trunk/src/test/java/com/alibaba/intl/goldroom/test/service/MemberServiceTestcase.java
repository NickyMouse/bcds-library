/**
 * 
 */
package com.alibaba.intl.goldroom.test.service;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.service.MemberService;
import com.alibaba.intl.goldroom.test.SpringAbstractIntegrationTestcaseBase;

/**
 * @author Harrison
 *
 */
public class MemberServiceTestcase extends
		SpringAbstractIntegrationTestcaseBase {

	@Autowired
	private MemberService memberService;
	
	@Test
	public void testServiceInjection(){
		Assert.assertNotNull(memberService);
		Member member = memberService.getMemberDao().findByLoginId("你好");
		Assert.assertNotNull(member);
	}
}
