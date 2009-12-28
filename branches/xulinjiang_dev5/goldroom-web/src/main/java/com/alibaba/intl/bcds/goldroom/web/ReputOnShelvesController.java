package com.alibaba.intl.bcds.goldroom.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.intl.bcds.goldroom.service.BookItemService;
import com.alibaba.intl.bcds.goldroom.service.result.Result;
import com.alibaba.intl.bcds.goldroom.web.utils.UserUtil;

/**
 * 将书籍重新上架
 * 
 * @author Giraffe
 * 
 */
public class ReputOnShelvesController extends AbstractController {

	private BookItemService bookItemService;

	/**
	 * @param bookItemService
	 *            the bookItemService to set
	 */
	public void setBookItemService(BookItemService bookItemService) {
		this.bookItemService = bookItemService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String bookItemIdStr = (String) request.getParameter("bookItemId");
		int bookItemId = 0;
		if (StringUtils.isNumeric(bookItemIdStr)) {
			bookItemId = Integer.valueOf(bookItemIdStr);
		}
		Result result= bookItemService.reputOnShelves(bookItemId, UserUtil.getUserName());
		if(result.isSuccess()){
			return new ModelAndView("/resources/reputOnShelvesSuccess");
		}else{
			return new ModelAndView("/friendlyError");
		}
	}
}
