package com.lj.spring.mapper;

import com.lj.spring.bean.User;

import java.util.List;

/**
 * Created by lj on 25/07/2017.
 */
public interface UserMapper {

    User getUser(int id);

    User getUserByUsername(String name,String password);


    void addUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    List<User> getAllUsers();

}
