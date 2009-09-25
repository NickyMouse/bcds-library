package com.alibaba.intl.bcds.goldroom.web.sample;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.alibaba.intl.bcds.goldroom.sample.User;
import com.alibaba.intl.bcds.goldroom.sample.service.UserService;

public class SampleController extends AbstractCommandController {

    public SampleController() {
        setCommandClass(User.class);
        setCommandName("user");
    }

    private UserService userService;

    /**
     * @param userService the userService to set
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response,
                                  Object command, BindException errors) throws Exception {
        User user = (User) command;
        if (user != null && StringUtils.isNotEmpty(user.getUsername())) {
            userService.addUser(user);
        }
        List<User> list = userService.listAllUser();
        return new ModelAndView("sample", "list", list);
    }

}
