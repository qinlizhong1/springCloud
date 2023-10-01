package com.qin.mapper;

import com.qin.entity.User;

import java.util.List;

public interface UserMapper {
    User queryUserById(Integer id);
    User queryUserByName(String name, String passwd);
    List<User> queryAll();
    //void deleteUser(Integer id);
}
