package com.smvc.annotation.components.web.controller;

import com.smvc.annotation.components.root.bean.User;
import com.smvc.annotation.components.root.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tk
 * @date 2019/6/11 23:41
 * @desc
 */
@RequestMapping(value = "/user", produces = "text/html;charset=utf-8")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "get")
    public String getUser(){
        User user = userService.getUser();

        return user.toString();
    }

    @GetMapping(value = "/success")
    public String success() {
        return "success";
    }
}
