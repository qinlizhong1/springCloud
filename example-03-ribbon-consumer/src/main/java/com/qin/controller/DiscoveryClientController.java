package com.qin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

//使用discovery client  进行客户端调用,需要自己实现负载均衡
@RestController
public class DiscoveryClientController {
    //1、注入DiscoveryClient实例
    @Autowired
    private DiscoveryClient discoveryClient;

    //2、注入LoadBalancerClient实例(需要先通过配置类创建该实例)
    @Autowired
    @Qualifier("discoveryClientRestTemplate")
    private RestTemplate restTemplate;

    //http://localhost:8300/discovery
    @RequestMapping("discovery")
    public String discoveryClientCallGetPort(){
        //3:得到的是RIBBONPRODUCER对应的所有实例地址信息，需要自己实现负载均衡去调用
        List<ServiceInstance> products = discoveryClient.getInstances("RIBBONPRODUCER");

        for (ServiceInstance serviceInstance : products){
            System.out.println("uri:" + serviceInstance.getUri());
            System.out.println("host:" + serviceInstance.getHost());
            System.out.println("port:" + serviceInstance.getPort());
            System.out.println("serviceId:" + serviceInstance.getServiceId());
            System.out.println("instanceId:" + serviceInstance.getInstanceId());
        }

        //4:自己实现负载均衡：模拟随机选择生产者服务一个实例
        int selector = new Random().nextInt(products.size());

        //5：调用
        String res = restTemplate.getForObject("http://localhost:" + products.get(selector).getPort() + "/port", String.class);

        return "【RibbonConsumer DiscoveryClient】--->" + res;

    }
}
