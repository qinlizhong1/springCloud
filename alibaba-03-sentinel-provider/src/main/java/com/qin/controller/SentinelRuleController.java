package com.qin.controller;

import com.alibaba.csp.sentinel.Tracer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rule")
public class SentinelRuleController {
    @RequestMapping("/t1")
    public String test1(){
        return "【sentinel rule】test1";
    }

    @RequestMapping("/t2")
    public Integer test2(Integer id){
        if (id < 0){
            throw new RuntimeException();
        }

        return id;
    }


    @RequestMapping("/t5")
    public String test5(){
        return "【Authorize rule】test5";
    }
}
