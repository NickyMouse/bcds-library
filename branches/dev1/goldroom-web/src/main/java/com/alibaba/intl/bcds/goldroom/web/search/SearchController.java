package com.alibaba.intl.bcds.goldroom.web.search;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchOption;
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

		boolean isAdvancedSearch = request.getParameter("isAdvancedSearch") == null ? false
				: true;
		String pageStr = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
		Map resultMap = new HashMap();
		BookSearchQueryObject queryObj = null;
		if (isAdvancedSearch) {
			BookSearchOption option = new BookSearchOption();
			option.setBookName(request.getParameter("bookName"));
			option.setDescription(request.getParameter("description"));
			option.setIsbn(request.getParameter("isbn"));
			option.setPublisher(request.getParameter("publisher"));
			option.setDaysBefore(request.getParameter("daysBefore"));

			queryObj = advancedSearch(option, pageStr, pageSize, resultMap);
			resultMap.put("searchOption", option);
		} else {
			String keywords = request.getParameter("q");
			if(StringUtils.isEmpty(keywords)){
				resultMap.put("noResult", true);
				return new ModelAndView("searchList",resultMap);
			}
			queryObj = keywordSearch(keywords, pageStr, pageSize, resultMap);
			resultMap.put("keywords", keywords);
		}
		resultMap.put("list", queryObj.getResultList());
		resultMap.put("pageNavView", PageUtils.createPageNavView(
				queryObj.getTotalCount(), request));
		return new ModelAndView("searchList", resultMap);
	}

	protected BookSearchQueryObject keywordSearch(String keywords,
			String pageStr, String pageSizeStr, Map resultMap) {
		BookSearchQueryObject queryObj = bookSearchService.searchBookByKeyword(
				keywords, PageUtils.getSkipResult(pageStr, pageSizeStr),
				PageUtils.getPageSize(pageSizeStr));
		return queryObj;
	}

	protected BookSearchQueryObject advancedSearch(BookSearchOption option,
			String pageStr, String pageSizeStr, Map resultMap) {
		BookSearchQueryObject queryObj = bookSearchService.advancedBookSearch(
				option, PageUtils.getSkipResult(pageStr, pageSizeStr),
				PageUtils.getPageSize(pageSizeStr));
		return queryObj;
	}
}
