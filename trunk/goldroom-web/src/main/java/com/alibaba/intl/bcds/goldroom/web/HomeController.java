package com.alibaba.intl.bcds.goldroom.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.intl.bcds.goldroom.dataobject.Integral;
import com.alibaba.intl.bcds.goldroom.dataobject.IntegralQuery;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.search.commons.service.BookSearchService;
import com.alibaba.intl.bcds.goldroom.service.IntegralService;
import com.alibaba.intl.bcds.goldroom.util.MemberInfoCache;
import com.alibaba.intl.bcds.goldroom.web.utils.StatisticsCache;
import com.alibaba.intl.bcds.goldroom.web.utils.UserUtil;
import com.alibaba.intl.bcds.goldroom.web.viewhelper.IntegralView;

public class HomeController extends AbstractController {

    private BookSearchService bookSearchService;
    private static Date       longAgo = new Date(0);
    private StatisticsCache   statisticsCache;
    private IntegralService   integralService;
    private MemberInfoCache   memberInfoCache;

    public void setMemberInfoCache(MemberInfoCache memberInfoCache) {
        this.memberInfoCache = memberInfoCache;
    }

    public void setIntegralService(IntegralService integralService) {
        this.integralService = integralService;
    }

    public void setStatisticsCache(StatisticsCache statisticsCache) {
        this.statisticsCache = statisticsCache;
    }

    public void setBookSearchService(BookSearchService bookSearchService) {
        this.bookSearchService = bookSearchService;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
                                                                                                          throws Exception {

        List newBookList = bookSearchService.searchBookByTime(longAgo, new Date(), 0, 5).getResultList();
        List popularBookList = bookSearchService.searchBookByInfoIds(statisticsCache.getPopularBookInfoIds()).getResultList();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("newBookList", newBookList);
        modelAndView.addObject("popularBookList", popularBookList);

        List<Integral> integralList = new ArrayList<Integral>();
        IntegralQuery integralQuery = new IntegralQuery();
        integralQuery.setOrderBy("value");
        integralQuery.setPsize(10);
        integralList = this.integralService.listByQuery(integralQuery);
        List<IntegralView> integralViewList = new ArrayList<IntegralView>();
        for (Integral i : integralList) {
            Member member = memberInfoCache.getMemberInfo(i.getLoginId());
            if(member != null){
                IntegralView iView = new IntegralView(member, i);
                integralViewList.add(iView);
            }
        }
        modelAndView.addObject("integralViewList", integralViewList);

        if (UserUtil.isLogin()) {
            modelAndView.addObject("userName", UserUtil.getUserName());
        }
        return modelAndView;
    }
}
