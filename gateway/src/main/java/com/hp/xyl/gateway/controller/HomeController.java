package com.hp.xyl.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Lizy
 * @since 2017-11-1
 **/
@Controller
public class HomeController {
    @RequestMapping({"/test/test", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/login?error")
    public String error() {
        return "error";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
