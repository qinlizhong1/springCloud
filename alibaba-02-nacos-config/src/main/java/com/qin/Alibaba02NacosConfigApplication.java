package com.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Alibaba02NacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(Alibaba02NacosConfigApplication.class, args);
        System.out.println("-------------  nacos config 启动成功 --------------");
    }
}
