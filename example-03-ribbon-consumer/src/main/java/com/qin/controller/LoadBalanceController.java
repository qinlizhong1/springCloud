package com.qin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoadBalanceController {

    //1、注入LoadBalancerClient实例
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //2、注入LoadBalancerClient实例(需要先通过配置类创建该实例)
    @Autowired
    @Qualifier("loadBalanceRestTemplate")
    private RestTemplate restTemplate;

    //http://localhost:8300/load
    @RequestMapping("load")
    public String loadBalanceClientCallGetPort(){
        //3、调用
        String res = restTemplate.getForObject("http://" + "RIBBONPRODUCER" + "/port", String.class);

        return "【RibbonConsumer LoadBalancer注解】--->" + res;

    }
}
