/**
 * @author 段连洁 [manajay.dlj@gmail.com]
 * @class UserServiceImpl
 * @description
 * @date 02/08/2017 4:42 PM
 */

package com.lj.spring.service;

import com.lj.spring.bean.User;
import com.lj.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(int id){
        return userMapper.getUser(id);
    }

    public User getUserByName(Map<String,String> params){
        User user = userMapper.getUserByName(params);
        return user;
    }

    public void addUser (User user) {
        userMapper.addUser(user);
    }

    public void deleteUser(int id){
        userMapper.deleteUser(id);
    }

    public void updateUser(User user){
        userMapper.updateUser(user);
    }

    public List<User> getAllUsers(){
        return  userMapper.getAllUsers();
    }

}
