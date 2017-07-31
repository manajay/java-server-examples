package com.lj.spring.service;

import com.lj.spring.bean.User;
import com.lj.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(int id){
        return userMapper.getUser(1);
    }

    public User getUserByUsername(String name,String password){
        return userMapper.getUserByUsername(name,password);
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
