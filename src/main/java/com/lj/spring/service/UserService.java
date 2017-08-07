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
    /**
    * 根据 索引 获取用户数据
    * @author        段连洁 [ manajay.dlj@gmail.com ]
    * @since         03/08/2017 11:33 AM
    * @param id      用户索引
    */
    User getUser(int id);

    /**
    * 根据map中的参数 查询用户
    * 实际开发应该废弃 map传参的方式, 因为这样导致业务可读性极差,不易于扩展和维护,建议,参数少于5个的时候 使用@Param注解的形式,多余5个
      则使用 JavaBean的方式传递参数, 将所有的参数封装成 POJO 的属性,参数传递为POJO类
    * @author        段连洁 [ manajay.dlj@gmail.com ]
    * @since         03/08/2017 11:34 AM
    * @param params  查询用户所需的map
    * @return
    */
    User getUserByMap(Map<String,String> params);
    /**
    * 注册用户
    * @author        段连洁 [ manajay.dlj@gmail.com ]
    * @since         03/08/2017 11:32 AM
    */
    void addUser (User user);

    /**
     * 删除用户
     * @author        段连洁 [ manajay.dlj@gmail.com ]
     * @since         03/08/2017 11:29 AM
     * @param id      用户索引
     */
    void deleteUser(int id);

    /**
     * 更新用户数据
     * @author        段连洁 [ manajay.dlj@gmail.com ]
     * @since         03/08/2017 11:25 AM
     * @param user    最新的用户数据模型
     */
    void updateUser(User user);

    /**
     * 获取 用户列表数据
     * @author   段连洁 [ manajay.dlj@gmail.com ]
     * @since    03/08/2017 11:22 AM
     * @method   getAllUsers
     * @return   用户列表
     */
    List<User> getAllUsers();

}
