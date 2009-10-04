package com.alibaba.intl.bcds.goldroom.web.search;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQueryObject;
import com.alibaba.intl.bcds.goldroom.search.commons.service.BookSearchService;
import com.alibaba.intl.bcds.goldroom.web.utils.PageUtils;

public class SearchController extends AbstractController {
	private BookSearchService bookSearchService;

	public void setBookSearchService(BookSearchService bookSearchService) {
		this.bookSearchService = bookSearchService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String keywords = request.getParameter("q");
		String pageStr = request.getParameter("page");
		if (StringUtils.isEmpty(keywords)) {
			return new ModelAndView("home");
		}

		BookSearchQueryObject queryObj = bookSearchService.searchBookByKeyword(
				keywords, PageUtils.getSkipResult(pageStr),
				PageUtils.PAGE_SIZE);
		Map map = new HashMap();
		map.put("list", queryObj.getResultList());
		map.put("keywords", keywords);
		map.put("totalCount", queryObj.getTotalCount());
		return new ModelAndView("search_list", map);
	}
}
