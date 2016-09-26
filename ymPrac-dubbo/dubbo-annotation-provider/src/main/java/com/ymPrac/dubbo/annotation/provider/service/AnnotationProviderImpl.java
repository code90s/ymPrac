package com.ymPrac.dubbo.annotation.provider.service;


import com.alibaba.dubbo.config.annotation.Service;

/**
 * Created by Yan Meng on 2016/9/23.
 */
@Service(version = "annotationProvider")
public class AnnotationProviderImpl implements AnnotationProvider {
    @Override
    public String sayAnnotation() {
        System.out.println("===============================================");
        return "hello annotation dubbo service";
    }
}
