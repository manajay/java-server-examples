package com.lj.spring.mapper;

import com.lj.spring.bean.User;

import java.util.List;
import java.util.Map;

/**
 * Created by lj on 25/07/2017.
 */
public interface UserMapper {

    User getUser(int id);

    public User getUserByName(Map<String,String> params);

    void addUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    List<User> getAllUsers();

}
