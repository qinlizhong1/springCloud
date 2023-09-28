package com.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Alibaba01NacosProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Alibaba01NacosProviderApplication.class, args);
        System.out.println("-------------  nacos provider 启动成功 --------------");
    }
}
