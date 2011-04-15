/**
 *
 */
package com.alibaba.intl.bcds.goldroom.util.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dataobject.UserDTO;
import com.alibaba.intl.bcds.goldroom.service.MemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author Harrison
 */
public class UserCAProcessInterceptor extends AbstractInterceptor {

    private static Logger           logger           = Logger.getLogger(UserCAProcessInterceptor.class);
    private transient MemberService memberService;
    /**
	 *
	 */
    private static final long       serialVersionUID = 6777422615852927394L;

    /*
     * (non-Javadoc)
     * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
     */
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext ctx = ActionContext.getContext();
        HttpServletRequest req = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
        HttpSession session = req.getSession();

        UserDTO userDto = (UserDTO) session.getAttribute(UserDTO.MEMBER_LOGGED_SESSION_KEY);
        if (userDto == null) {
            // 用户未登录
            req.getHeaderNames();
            String email = this.getEmailFromCert(req);
            if (StringUtils.isNotBlank(email) && email.indexOf("@") >= 1) {
                // 有证书
                Member member = memberService.findMemberByEmail(email);
                if (member != null && StringUtils.isNotBlank(member.getName())) {
                    putUserToSession(session, member);
                } else {
                    // 会员不存在，直接调用服务创建会员，并开通服务
                    Member regMember = memberService.autoRegistByEmail(email);
                    if (regMember != null) {
                        putUserToSession(session, regMember);
                    }
                }
            }
        }
        return invocation.invoke();
    }

    private void putUserToSession(HttpSession session, Member member) {
        UserDTO userDto;
        userDto = new UserDTO();
        userDto.setId(member.getId());
        userDto.setUserName(member.getName());
        userDto.setScore(member.getScore());
        userDto.setLoginId(member.getLoginId());
        session.setAttribute(UserDTO.MEMBER_LOGGED_SESSION_KEY, userDto);
    }

    public MemberService getMemberService() {
        return memberService;
    }

    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    public String getEmailFromCert(HttpServletRequest req) {
        String email = req.getHeader(UserDTO.SSL_CLIENT_S_DN_Email);
        if (email == null) {
            try {
                String dn = req.getHeader(UserDTO.SSL_CLIENT_S_DN);
                if (dn == null) {
                    return null;
                }
                int start = dn.indexOf("emailAddress=");
                int end = dn.indexOf("/", start);
                if (start < 0) {
                    return null;
                } else {
                    start = start + "emailAddress=".length();
                }

                if (end < 0) {
                    email = dn.substring(start, dn.length());
                } else {
                    email = dn.substring(start, end);
                }
            } catch (Exception e) {
                logger.error("Error parse email from SSL_CLIENT_S_DN in nginx");
                return null;
            }
        }
        return email;
    }
}
