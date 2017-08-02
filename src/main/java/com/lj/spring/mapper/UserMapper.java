package com.lj.spring.mapper;

import com.lj.spring.bean.User;

import java.util.List;
import java.util.Map;

/**
 * @author 段连洁 [manajay.dlj@gmail.com]
 * @class UserManager
 * @description
 * @date 02/08/2017 4:42 PM
 */
public interface UserMapper {

    User getUser(int id);

    public User getUserByName(Map<String,String> params);

    void addUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    List<User> getAllUsers();

}
