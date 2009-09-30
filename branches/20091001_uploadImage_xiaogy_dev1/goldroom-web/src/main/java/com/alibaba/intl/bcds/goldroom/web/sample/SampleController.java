package com.alibaba.intl.bcds.goldroom.web.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.sample.User;
import com.alibaba.intl.bcds.goldroom.sample.service.UserService;

public class SampleController extends SimpleFormController {

    private UserService userService;

    /**
     * @param userService the userService to set
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Object command, BindException errors) throws Exception {
        User user = (User) command;
        if (user != null && StringUtils.isNotEmpty(user.getUsername())) {
            userService.addUser(user);
        }
        List<User> list = userService.listAllUser();
        Map<String, List<User>> map = new HashMap<String, List<User>>();
        map.put("list", list);
        return showForm(request, response, errors, map);
    }
}
