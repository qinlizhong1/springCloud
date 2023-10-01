package com.qin.controller;

import com.qin.entity.User;
import com.qin.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//为了简单，没有引入service层，直接在controller中操作mapper
@RestController
@RequestMapping("/serverD")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    //http://localhost:7104/serverD/findUserById?id=-3
    @RequestMapping("/findUserById")
    public User findUserById(Integer id){

        User user = null;
        if (id <= 0){
            log.error("非法id:{}", id);
            return user;
        }


        user = userMapper.queryUserById(id);
        log.error("查询id:{}成功", id);

        return user;
    }

}
