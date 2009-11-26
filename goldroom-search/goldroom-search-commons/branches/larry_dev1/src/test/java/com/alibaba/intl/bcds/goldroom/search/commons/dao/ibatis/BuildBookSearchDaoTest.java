package com.alibaba.intl.bcds.goldroom.search.commons.dao.ibatis;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.intl.bcds.goldroom.search.commons.dao.BuildBookSearchDao;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildBookSearch;

public class BuildBookSearchDaoTest extends TestCase {

	BuildBookSearchDao buildBookSearchDao;

	protected void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"goldroom-search-commons.xml");
		buildBookSearchDao = (BuildBookSearchDao) context
				.getBean("buildBookSearchDao");
	}

	public void testListAllBook() {
		List<BuildBookSearch> result = buildBookSearchDao.listAllBook(1);
		for (BuildBookSearch buildBookSearch : result) {
			System.out.println(buildBookSearch.getBookTags());
		}
	}

	public void testListAllCategory() {
		// Map<Integer, BuildCategorySearchDO> map =
		// buildBookSearchDao.listAllCategory();
		// Collection<BuildCategorySearchDO> result = map.values();
		// for(BuildCategorySearchDO buildCategorySearchDO : result){
		// System.out.println(buildCategorySearchDO.getId() + "  " +
		// buildCategorySearchDO.getName());
		// }
	}

	public void testListBookByTime() throws ParseException{
		//'2009-10-18 20:12:11''2009-10-18 20:12:11'),
		//UNIX_TIMESTAMP('2009-10-18 20:14:11')
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		Date startTime = df.parse("2009-10-18 20:37:00.123");
		Date endTime = df.parse("2009-10-18 20:38:00.123");
		System.out.println(startTime);
		System.out.println(endTime);
		List<BuildBookSearch> result = buildBookSearchDao.listBookByTime(startTime, endTime);
		for(BuildBookSearch buildBookSearch : result){
			System.out.println("ttttt  "+buildBookSearch.getBookTags());
		}
	}
}
