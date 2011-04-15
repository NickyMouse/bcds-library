package com.alibaba.intl.bcds.goldroom.util.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.intl.bcds.goldroom.dataobject.Tracelog;
import com.alibaba.intl.bcds.goldroom.dataobject.UserDTO;
import com.alibaba.intl.bcds.goldroom.service.TracelogService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TracelogInterceptor extends AbstractInterceptor {

    /**
     *
     */
    private static final long serialVersionUID = -8273211656056481962L;

    private TracelogService   tracelogService;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext ctx = ActionContext.getContext();
        HttpServletRequest req = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
        HttpSession session = req.getSession();

        String log = req.getParameter("log");
        if (!"no".equals(log)) {
            Tracelog tl = new Tracelog();
            tl.setGmtCreate(new Date());
            tl.setReferer(req.getHeader("Referer"));
            tl.setEmail(req.getHeader(UserDTO.SSL_CLIENT_S_DN_Email));
            tl.setPath(req.getServletPath());
            tl.setIp(req.getRemoteAddr());
            tl.setParam(req.getParameter("log"));
            tl.setParam1(req.getParameter("log1"));
            tl.setParam2(req.getParameter("log2"));
            tracelogService.saveTracelog(tl);
        }
        return invocation.invoke();
    }

    public void setTracelogService(TracelogService tracelogService) {
        this.tracelogService = tracelogService;
    }

    public TracelogService getTracelogService() {
        return tracelogService;
    }

}
