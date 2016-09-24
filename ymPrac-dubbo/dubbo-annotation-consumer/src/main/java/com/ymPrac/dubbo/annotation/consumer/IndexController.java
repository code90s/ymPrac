package com.ymPrac.dubbo.annotation.consumer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Yan Meng on 2016/9/24.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    @ResponseBody
    public String index () {
        return "asdfasdf";
    }
}
