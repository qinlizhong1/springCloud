package com.qin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.qin.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class Linktrace01SleuthServerDApplication {

    public static void main(String[] args) {
        SpringApplication.run(Linktrace01SleuthServerDApplication.class, args);
        System.out.println("-------------  sleuth-server-d 启动成功 --------------");
    }

}
