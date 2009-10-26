package com.alibaba.intl.bcds.goldroom.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.intl.bcds.goldroom.search.commons.service.BookSearchService;
import com.alibaba.intl.bcds.goldroom.web.utils.UserUtil;

public class HomeController extends AbstractController {
	private BookSearchService bookSearchService;
	private static Date longAgo = new Date(0);

	public void setBookSearchService(BookSearchService bookSearchService) {
		this.bookSearchService = bookSearchService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List newBookList = bookSearchService.searchBookByTime(longAgo,
				new Date(), 0, 5).getResultList();
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("newBookList", newBookList);
		modelAndView.addObject("popularBookList", newBookList);
		if (UserUtil.isLogin()) {
			modelAndView.addObject("userName", UserUtil.getUserName());
		}
		return modelAndView;
	}
}
