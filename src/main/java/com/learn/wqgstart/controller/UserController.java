package com.learn.wqgstart.controller;

import com.learn.wqgstart.model.User;
import com.learn.wqgstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wangqinggang on 2022/10/5.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public String register(@ModelAttribute User user, Model model) {
        if (userService.register(user)) {
            return "/index";
        }
        model.addAttribute("error",true);
        return "/register";
    }

}
