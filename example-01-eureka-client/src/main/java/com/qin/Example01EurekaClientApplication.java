package com.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Example01EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Example01EurekaClientApplication.class, args);
        System.out.println("-------------  eureka client 启动成功 --------------");
    }
}
