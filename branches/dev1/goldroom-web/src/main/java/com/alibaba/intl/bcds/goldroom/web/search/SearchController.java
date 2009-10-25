package com.alibaba.intl.bcds.goldroom.web.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQueryObject;
import com.alibaba.intl.bcds.goldroom.search.commons.service.BookSearchService;
import com.alibaba.intl.bcds.goldroom.web.utils.PageUtils;

@SuppressWarnings("unchecked")
public class SearchController extends AbstractController {
	private BookSearchService bookSearchService;

	public void setBookSearchService(BookSearchService bookSearchService) {
		this.bookSearchService = bookSearchService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		boolean isAdvancedSearch = request.getAttribute("isAdvancedSearch") == null ? true
				: false;
		String pageStr = request.getParameter("page");

		Map resultMap = new HashMap();
		if (isAdvancedSearch) {

		} else {
			String keywords = request.getParameter("q");
			keywordSearch(keywords, pageStr, resultMap);
		}

		return new ModelAndView("searchList", resultMap);
	}

	protected void keywordSearch(String keywords, String pageStr, Map resultMap) {
		BookSearchQueryObject queryObj = bookSearchService
				.searchBookByKeyword(keywords,
						PageUtils.getSkipResult(pageStr), PageUtils.PAGE_SIZE);
		resultMap.put("list", queryObj.getResultList());
		resultMap.put("totalCount", queryObj.getTotalCount());
		resultMap.put("keywords", keywords);
	}

	protected void advancedSearch(Map resultMap) {
		//TODO
		resultMap.put("list", new ArrayList());
		resultMap.put("totalCount", 0);
	}
}
