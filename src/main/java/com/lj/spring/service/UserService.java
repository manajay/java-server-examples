/**
 * @author 段连洁 [manajay.dlj@gmail.com]
 * @class UserService
 * @description
 * @date 02/08/2017 4:42 PM
 */

package com.lj.spring.service;

import com.lj.spring.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {

    public User getUser(int id);

    public User getUserByName(Map<String,String> params);

    public void addUser (User user);

    public void deleteUser(int id);

    public void updateUser(User user);

    public List<User> getAllUsers();

}
