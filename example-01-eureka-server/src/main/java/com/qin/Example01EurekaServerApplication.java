package com.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Example01EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Example01EurekaServerApplication.class, args);
        System.out.println("-------------  eureka server 启动成功 --------------");
    }

}
