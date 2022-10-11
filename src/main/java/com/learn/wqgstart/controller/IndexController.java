package com.learn.wqgstart.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by wangqinggang on 2021/03/06.
 */
@Controller
public class IndexController {

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/register")
    public String register() {
        return "register";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/login-error")
    public String loginError(Model model) {
        model.addAttribute("error",true);
        return "login";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/admin")
    public String admin() {
        return "admin";
    }

}
