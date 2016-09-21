package com.ymPrac.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Yan Meng on 2016/9/21.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }
}
