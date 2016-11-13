package com.ymPrac.mq.kafka.producer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Yan Meng on 2016/10/18.
 */
@Controller
public class TestController {

    @RequestMapping("/")
    @ResponseBody
    public String index (String in) {
        return in;
    }
}
