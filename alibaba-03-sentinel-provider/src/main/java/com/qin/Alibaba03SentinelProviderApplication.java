package com.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Alibaba03SentinelProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Alibaba03SentinelProviderApplication.class, args);
        System.out.println("-------------  sentinel provider 启动成功 --------------");
    }

}
