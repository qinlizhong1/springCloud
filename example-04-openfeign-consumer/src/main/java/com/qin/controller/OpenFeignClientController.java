package com.qin.controller;

import com.qin.feignclient.OpenFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OpenFeignClientController {

    @Autowired
    private OpenFeignClient openFeignClient;

    @GetMapping("/c1")
    public Map<String,Object> findOne(String id){
        Map<String, Object> res = openFeignClient.findOne(id);
        return res;
    }

    @GetMapping("/t2/{id}")
    public Map<String,Object> findTwo(@PathVariable("id") String id){
        Map<String, Object> map = openFeignClient.findTwo(id);
        return map;
    }
}
