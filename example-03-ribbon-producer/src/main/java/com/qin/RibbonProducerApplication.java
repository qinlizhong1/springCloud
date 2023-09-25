package com.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RibbonProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonProducerApplication.class, args);
        System.out.println("-------------  ribbon producer 启动成功 --------------");
    }

}
