package com.qin.controller;

import com.qin.resource.AnnotationResource;
import com.qin.resource.BoolenResResource;
import com.qin.resource.ThrowExceptionResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelProviderController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/t1")
    public String test1(){
        return "【sentinel provider】test1 我的端口是--->" + port;
    }

    @RequestMapping("/t2")
    public String test2(){
        return ThrowExceptionResource.method();
    }

    @RequestMapping("/t3")
    public String test3(){
        return BoolenResResource.method();
    }

    @RequestMapping("/t4")
    public String test4(){
        return AnnotationResource.method();
    }
}
