package com.al._01springsecuritydemo01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // http://localhost:8081
    @GetMapping("/index")
    public String index() {
        return "index";
    }


    // 管理
    @GetMapping("/system/user")
    public String userList() {
        return "user";
    }

    @GetMapping("/system/role")
    public String roleList() {
        return "role";
    }

    @GetMapping("/system/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/order")
    public String orderList() {
        return "order";
    }
}
