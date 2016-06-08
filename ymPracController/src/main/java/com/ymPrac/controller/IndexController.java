package com.ymPrac.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Yan Meng on 2016/6/8.
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/")
    @ResponseBody
    public String index (HttpServletRequest request) {
        return "hellow";
    }
}
