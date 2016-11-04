package com.xiaodong.will.find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 */
@Controller
public class MainController {

    @RequestMapping("main.do")
    public String main() {
        return "main";
    }
}
