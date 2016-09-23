package com.ymPrac.dubbo.annotation.provider.service;

import org.springframework.stereotype.Service;

/**
 * Created by Yan Meng on 2016/9/23.
 */
@Service(value = "annotationProvider")
public class AnnotationProviderImpl implements AnnotationProvider {
    @Override
    public String sayAnnotation() {
        return "hello annotation dubbo service";
    }
}
