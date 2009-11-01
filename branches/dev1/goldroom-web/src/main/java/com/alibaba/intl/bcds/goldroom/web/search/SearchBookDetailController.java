package com.alibaba.intl.bcds.goldroom.web.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearch;
import com.alibaba.intl.bcds.goldroom.search.commons.service.BookSearchService;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;
import com.alibaba.intl.bcds.goldroom.service.MemberService;

@SuppressWarnings("unchecked")
public class SearchBookDetailController extends AbstractController {
	private BookItemService bookItemService;
	private BookSearchService bookSearchService;
	private MemberService memberService;

	public void setBookSearchService(BookSearchService bookSearchService) {
		this.bookSearchService = bookSearchService;
	}

	public void setBookItemService(BookItemService bookItemService) {
		this.bookItemService = bookItemService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int bookInfoId = Integer.parseInt(request.getParameter("id"));
		boolean showOwners = Boolean
				.valueOf(request.getParameter("showOwners"));
		BookSearch bookSearchInfo = bookSearchService
				.searchBookByInfoId(new Integer(bookInfoId));
		ModelAndView mv = new ModelAndView("searchBookDetail");
		mv.addObject("bookSearchInfo", bookSearchInfo);
		if (showOwners) {
			List<BookItem> bookItemList = bookItemService
					.listBookItemByBookInfoId(bookInfoId);
			List memberIds = new ArrayList();
			for (BookItem bookItem : bookItemList) {
				memberIds.add(bookItem.getLoginId());
			}
			List memberInfoList = new ArrayList();
			if (memberIds.size() > 0) {
				memberInfoList = memberService.listMemberByLoginIds(memberIds);
			}
			mv.addObject("bookItemList", bookItemList);
			mv.addObject("ownerInfoList", memberInfoList);
		}
		return mv;
	}
}
