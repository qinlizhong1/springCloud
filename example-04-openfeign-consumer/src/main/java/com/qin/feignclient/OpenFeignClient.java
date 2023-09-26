package com.qin.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

//value值是服务提供者名称
@FeignClient(value = "OPENFEIGNPROVIDER")
public interface OpenFeignClient {
    //普通表单参数
    @GetMapping("/t1")
    public Map<String,Object> findOne(@RequestParam("id") String id);

    //URL中携带参数
    @GetMapping("/t2/{id}")
    public Map<String,Object> findTwo(@PathVariable("id") String id);
}
