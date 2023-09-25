package com.qin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class LoadBalanceClientController {

    //1、注入LoadBalancerClient实例
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //2、注入LoadBalancerClient实例(需要先通过配置类创建该实例)
    @Autowired
    @Qualifier("loadBalanceClientRestTemplate")
    private RestTemplate restTemplate;

    //http://localhost:8300/loadclient
    @RequestMapping("loadclient")
    public String loadBalanceClientCallGetPort(){
        //3、得到具体某个实例地址信息，不需要自己实现负载均衡去调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("RIBBONPRODUCER");


        //4、调用
        String res = restTemplate.getForObject("http://localhost:" + serviceInstance.getPort() + "/port", String.class);

        return "【RibbonConsumer LoadBalancerClient】--->" + res;

    }
}
