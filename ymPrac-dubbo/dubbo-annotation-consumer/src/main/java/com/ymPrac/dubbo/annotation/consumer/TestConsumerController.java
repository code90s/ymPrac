package com.ymPrac.dubbo.annotation.consumer;

import com.ymPrac.dubbo.annotation.provider.service.AnnotationProvider;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Yan Meng on 2016/9/24.
 */
@Controller
public class TestConsumerController {

    @Resource
    private AnnotationProvider annotationProvider;

    @RequestMapping("/test")
    @ResponseBody
    public String testAnnotation () {
        return annotationProvider.sayAnnotation();
    }
}
