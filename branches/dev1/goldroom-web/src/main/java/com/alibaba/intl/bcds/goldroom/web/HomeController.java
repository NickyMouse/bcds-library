package com.alibaba.intl.bcds.goldroom.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.intl.bcds.goldroom.search.commons.service.BookSearchService;

public class HomeController extends AbstractController {
	private BookSearchService bookSearchService;

	public void setBookSearchService(BookSearchService bookSearchService) {
		this.bookSearchService = bookSearchService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("home");
	}

}
