package com.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Example04OpenfeignProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Example04OpenfeignProviderApplication.class, args);
        System.out.println("-------------  openfeign provider 启动成功 --------------");
    }

}
