package com.alibaba.intl.bcds.goldroom.web.search;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQueryObject;
import com.alibaba.intl.bcds.goldroom.search.commons.service.BookSearchService;
import com.alibaba.intl.bcds.goldroom.web.utils.PageUtils;

public class AllBookController extends AbstractController {
	private BookSearchService bookSearchService;

	public void setBookSearchService(BookSearchService bookSearchService) {
		this.bookSearchService = bookSearchService;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String pageStr = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
		Map resultMap = new HashMap();
		BookSearchQueryObject queryObj = bookSearchService.listAllBook(
				PageUtils.getSkipResult(pageStr, pageSize), PageUtils
						.getPageSize(pageSize));
		resultMap.put("list", queryObj.getResultList());
		resultMap.put("pageNavView", PageUtils.createPageNavView(queryObj
				.getTotalCount(), request));
		return new ModelAndView("searchList", resultMap);
	}
}
