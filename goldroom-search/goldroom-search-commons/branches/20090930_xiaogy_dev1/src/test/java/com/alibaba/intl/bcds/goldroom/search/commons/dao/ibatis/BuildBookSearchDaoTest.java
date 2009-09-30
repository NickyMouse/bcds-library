package com.alibaba.intl.bcds.goldroom.search.commons.dao.ibatis;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.intl.bcds.goldroom.search.commons.dao.BuildBookSearchDao;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildBookSearchDO;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildCategorySearchDO;

public class BuildBookSearchDaoTest extends TestCase {

	BuildBookSearchDao buildBookSearchDao;

	protected void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"goldroom-search-commons.xml");
		buildBookSearchDao = (BuildBookSearchDao) context
				.getBean("buildBookSearchDao");
	}

	public void testListAllBook() {
		List<BuildBookSearchDO> result = buildBookSearchDao.listAllBook(1);
		for(BuildBookSearchDO buildBookSearchDO : result){
			System.out.println(buildBookSearchDO.getItemId());
		}
	}

	public void testListAllCategory() {
		Map<Integer, BuildCategorySearchDO> map = buildBookSearchDao.listAllCategory();
		Collection<BuildCategorySearchDO> result = map.values();
		for(BuildCategorySearchDO buildCategorySearchDO : result){
			System.out.println(buildCategorySearchDO.getId() + "  " + buildCategorySearchDO.getName());
		}
	}

}
