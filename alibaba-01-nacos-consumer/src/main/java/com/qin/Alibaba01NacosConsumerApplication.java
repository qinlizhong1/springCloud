package com.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Alibaba01NacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Alibaba01NacosConsumerApplication.class, args);
        System.out.println("-------------  nacos consumer 启动成功 --------------");
    }

}
