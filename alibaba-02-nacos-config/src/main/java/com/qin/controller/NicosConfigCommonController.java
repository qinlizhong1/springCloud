package com.qin.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@ConfigurationProperties("spring.datasource")
public class NicosConfigCommonController {

    private String url;

    private String username;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @RequestMapping("config/common")
    public Map<String, String> getConfig(){
        Map<String, String> stringStringMap = new HashMap<>();

        stringStringMap.put("url", url);
        stringStringMap.put("username",username);

        return stringStringMap;
    }
}
