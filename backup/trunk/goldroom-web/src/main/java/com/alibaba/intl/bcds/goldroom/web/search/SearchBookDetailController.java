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
import com.alibaba.intl.bcds.goldroom.web.utils.StatisticsCache;

@SuppressWarnings("unchecked")
public class SearchBookDetailController extends AbstractController {

    private BookItemService   bookItemService;
    private BookSearchService bookSearchService;
    private MemberService     memberService;
    private StatisticsCache   statisticsCache;

    public void setStatisticsCache(StatisticsCache statisticsCache) {
        this.statisticsCache = statisticsCache;
    }

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
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
                                                                                                          throws Exception {

        int bookInfoId = Integer.parseInt(request.getParameter("id"));
        boolean showOwners = Boolean.valueOf(request.getParameter("showOwners"));
        BookSearch bookSearchInfo = bookSearchService.searchBookByInfoId(new Integer(bookInfoId));
        if (bookSearchInfo == null) {
            return new ModelAndView("/resources/bookNotFound");
        }
        ModelAndView mv = new ModelAndView("searchBookDetail");
        mv.addObject("bookSearchInfo", bookSearchInfo);
        if (showOwners) {
            List<BookItem> bookItemList = bookItemService.listBookItemByBookInfoId(bookInfoId);
            List<BookItem> displayBookItemList = new ArrayList<BookItem>();
            List memberIds = new ArrayList();
            for (BookItem bookItem : bookItemList) {
                if (!BookItem.STATE_UNAVAILABLE.equals(bookItem.getState())) {
                    memberIds.add(bookItem.getLoginId());
                    displayBookItemList.add(bookItem);
                }
            }
            List memberInfoList = new ArrayList();
            if (memberIds.size() > 0) {
                memberInfoList = memberService.listMemberByLoginIds(memberIds);
            }
            statisticsCache.addOne(bookInfoId);
            mv.addObject("bookItemList", displayBookItemList);
            mv.addObject("ownerInfoList", memberInfoList);
        }
        return mv;
    }
}
