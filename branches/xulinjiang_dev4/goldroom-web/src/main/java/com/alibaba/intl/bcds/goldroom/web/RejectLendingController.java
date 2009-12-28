package com.alibaba.intl.bcds.goldroom.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.intl.bcds.goldroom.service.BookItemService;
import com.alibaba.intl.bcds.goldroom.web.utils.UserUtil;

/**
 * 当书本被预约时，拥有者不批准借阅
 * 
 * @author Giraffe
 * 
 */
public class RejectLendingController extends AbstractController {

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
		String reservationIdStr = (String) request.getParameter("reservationId");
		int reservationId = 0;
		if (StringUtils.isNumeric(reservationIdStr)) {
			reservationId = Integer.valueOf(reservationIdStr);
		}
		bookItemService.rejectLend(reservationId, UserUtil.getUserName());
		return new ModelAndView("redirect:/user/myBooks.htm");
	}

}
