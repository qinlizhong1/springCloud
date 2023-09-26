package com.qin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OpenFeignProviderController {
    @Value("${server.port}")
    private String port;

    //普通表单参数
    @GetMapping("/t1")
    public Map<String,Object> findOne(String id){
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("port", port);
        map.put("productId", id);
        return map;
    }

    //URL中携带参数
    @GetMapping("/t2/{id}")
    public Map<String,Object> findTwo(@PathVariable("id") String id){
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("port", port);
        map.put("productId", id);
        return map;
    }
}
