package com.qin.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced
    public RestTemplate loadBalanceRestTemplate(@Qualifier("simpleClientHttpRequestFactory")
                                                              ClientHttpRequestFactory factory){
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
         SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
         factory.setConnectTimeout(15000);
         // 获取数据超时时间 毫秒
         factory.setReadTimeout(5000);
         return factory;
     }
}
