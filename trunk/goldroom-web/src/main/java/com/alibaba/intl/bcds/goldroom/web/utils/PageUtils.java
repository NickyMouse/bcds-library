package com.alibaba.intl.bcds.goldroom.web.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public class PageUtils {

    /**默认页码*/
    public final static int DEFAULT_PAGE      = 1;

    /**默认每页面条数*/
    public final static int DEFAULT_PAGE_SIZE = 10;

    protected static int getInt(String pageStr) {
    	return NumberUtils.toInt(pageStr);
    }

    public static int getSkipResult(String pageStr, String pageSizStr) {
        int page = getInt(pageStr);
        if (page <= 0) {
            page = PageUtils.DEFAULT_PAGE;
        }
        return (page - 1) * getPageSize(pageSizStr);
    }

    public static int getPage(String pageStr) {
        int page = getInt(pageStr);
        if (page <= 0) {
            page = PageUtils.DEFAULT_PAGE;
        }
        return page;
    }

    public static int getPageSize(String pageSizeStr) {
        int pageSize = getInt(pageSizeStr);
        if (pageSize <= 0) {
            pageSize = PageUtils.DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    /**
     * 获取当前访问的url，去除名字为page的query参数
     * 
     * @param request
     * @return 去除名字为page参数后的url
     */
    public static String getCurrentUrl(HttpServletRequest request) {
        StringBuilder url = new StringBuilder(request.getRequestURL());
        url.append("?");
        String queryString = request.getQueryString();
        if (StringUtils.isEmpty(queryString)) {
            return url.toString();
        }

        int pageIndex = queryString.indexOf("page=");
        if (pageIndex >= 0) {
            int endIndex = queryString.indexOf("&", pageIndex);
            if (endIndex < 0) {
                url.append(queryString.substring(0, pageIndex - 1));
            } else {
                url.append(queryString.substring(0, pageIndex));
                url.append(queryString.substring(endIndex + 1, queryString.length()));
            }
        } else {
            url.append(queryString);
        }
        return url.toString();
    }

    public static PageNavView createPageNavView(int totalCount, HttpServletRequest request) {
        PageNavView pageNavView = new PageNavView();
        pageNavView.setCurrentPage(PageUtils.getPage(request.getParameter("page")));
        pageNavView.setPageSize(PageUtils.getPageSize(request.getParameter("pageSize")));
        pageNavView.setTotalCount(totalCount);
        pageNavView.setCurrentUrl(PageUtils.getCurrentUrl(request));
        return pageNavView;
    }
}
