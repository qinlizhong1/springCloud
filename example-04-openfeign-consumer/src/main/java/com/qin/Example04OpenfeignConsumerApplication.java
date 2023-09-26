package com.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Example04OpenfeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Example04OpenfeignConsumerApplication.class, args);
        System.out.println("-------------  openfeign client 启动成功 --------------");
    }
}
