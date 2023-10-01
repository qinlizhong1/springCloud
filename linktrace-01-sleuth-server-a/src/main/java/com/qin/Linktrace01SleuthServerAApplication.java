package com.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Linktrace01SleuthServerAApplication {

    public static void main(String[] args) {
        SpringApplication.run(Linktrace01SleuthServerAApplication.class, args);
        System.out.println("-------------  sleuth-server-a 启动成功 --------------");
    }
}
