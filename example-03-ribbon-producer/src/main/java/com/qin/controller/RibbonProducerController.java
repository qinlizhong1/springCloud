package com.qin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonProducerController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/port")
    public String getPort(){
        return "【RibbonProducer】我的端口是--->" + port;
    }
}
