package com.qin.controller;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@ConfigurationProperties
public class NicosConfigController {

    private String k;

    private String common_k;

    public void setK(String k) {
        this.k = k;
    }

    public void setCommon_k(String common_k) {
        this.common_k = common_k;
    }

    @RequestMapping("config")
    public Map<String, String> getConfig(){
        Map<String, String> stringStringMap = new HashMap<>();

        stringStringMap.put("k", k);
        stringStringMap.put("common_k", common_k);

        return stringStringMap;
    }
}
