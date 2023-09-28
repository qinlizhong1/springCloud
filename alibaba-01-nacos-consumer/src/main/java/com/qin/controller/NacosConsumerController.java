package com.qin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosConsumerController {

    //1、注入LoadBalancerClient实例
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //2、注入LoadBalancerClient实例(需要先通过配置类创建该实例)
    @Autowired
    @Qualifier("loadBalanceRestTemplate")
    private RestTemplate restTemplate;

    //http://localhost:9100/load
    @RequestMapping("load")
    public String loadBalanceClientCallGetPort(){
        //3、调用
        String res = restTemplate.getForObject("http://" + "nacos-provider" + "/port", String.class);

        return "【Nicos Consumer LoadBalancer注解】--->" + res;

    }
}
