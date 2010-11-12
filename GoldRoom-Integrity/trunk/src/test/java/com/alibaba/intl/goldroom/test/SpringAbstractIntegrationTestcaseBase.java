/**
 * 
 */
package com.alibaba.intl.goldroom.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * 整体测试框架的基础类，自动加载context配置内容，各测试类上，需要在注入的service前增加
 * <code> @Autowired </code>标注，同时因为采用JUnit4的规范，在每个测试方法前标注
 * <code> @Test </code>标注
 * 
 * @author Harrison
 *
 */

@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class SpringAbstractIntegrationTestcaseBase extends
			AbstractJUnit4SpringContextTests {
	
}
