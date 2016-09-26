package com.ymPrac.dubbo.annotation.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ymPrac.dubbo.annotation.provider.service.AnnotationProvider;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Yan Meng on 2016/9/24.
 */
@Controller
public class IndexController {

//    @Reference(version = "1.0.0", interfaceClass = AnnotationProvider.class, interfaceName = "annotationProvider", consumer = "defaultConsumer")
    @Reference
    private AnnotationProvider annotationProvider;

    @RequestMapping("/index")
    @ResponseBody
    public String index () {
        return "asdfasdf";
    }

    @RequestMapping("/dubbo")
    @ResponseBody
    public String dubbo () {

        return annotationProvider.sayAnnotation();
    }
}
