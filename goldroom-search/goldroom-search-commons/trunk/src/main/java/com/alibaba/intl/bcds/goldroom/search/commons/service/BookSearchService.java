package com.alibaba.intl.bcds.goldroom.search.commons.service;

import java.util.Date;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearchDO;

public interface BookSearchService {
	public List<BookSearchDO> searchBookByCategoryId(Integer id, Integer number);

	public List<BookSearchDO> searchBookByKeyword(String fieldName,
			String keyword, Integer number);

	public List<BookSearchDO> searchBookByTime(Date startTime, Date endTime,
			Integer number);
}
