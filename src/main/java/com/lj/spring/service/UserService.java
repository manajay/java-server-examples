package com.lj.spring.service;

import com.lj.spring.bean.User;

import java.util.List;

public interface UserService {

    public User getUser(int id);

    public User getUserByUsername(String name,String password);

    public void addUser (User user);

    public void deleteUser(int id);

    public void updateUser(User user);

    public List<User> getAllUsers();

}
