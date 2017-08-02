package com.lj.spring.controller;

import com.lj.spring.bean.User;
import com.lj.spring.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    static Logger log = Logger.getLogger(UserController.class.getName());

    @RequestMapping("/gotoRegister")
    /**
     * @Author 段连洁 [ manajay.dlj@gmail.com ]
     * @Date   02/08/2017 4:41 PM
     * @Method gotoRegister
     * @Params []
     * @Return org.springframework.web.servlet.ModelAndView
     */
    public ModelAndView gotoRegister () {
        ModelAndView userView = new ModelAndView();
        userView.setViewName("userRegisterView");
        return userView;
    }

    @RequestMapping("/goToWelcome")
    /**
     * @Author 段连洁 [ manajay.dlj@gmail.com ]
     * @Date   02/08/2017 4:41 PM
     * @Method goToWelcome
     * @Params []
     * @Return org.springframework.web.servlet.ModelAndView
     */
    public ModelAndView  goToWelcome(){
        ModelAndView userView = new ModelAndView();
        userView.setViewName("index");
        return userView;
    }


    @RequestMapping("/userRegister")
    /**
     * @Author 段连洁 [ manajay.dlj@gmail.com ]
     * @Date   02/08/2017 4:41 PM
     * @Method userRegister
     * @Params [user]
     * @Return org.springframework.web.servlet.ModelAndView
     */
    public ModelAndView userRegister (User user) {
        userService.addUser(user);

        return showUserList();
    }

    @RequestMapping("/userLogin")
    /**
     * @Author 段连洁 [ manajay.dlj@gmail.com ]
     * @Date   02/08/2017 4:40 PM
     * @Method userLogin
     * @Params [request]
     * @Return org.springframework.web.servlet.ModelAndView
     */
    public ModelAndView userLogin(HttpServletRequest request) {
        //      获取参数
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        //      创建map
        Map<String,String> map = new HashMap<String, String>();
        map.put("name",name);
        map.put("password",password);

        //      根据map查询
        User user = userService.getUserByName(map);
        log.debug(user);

        if (user == null){
            log.debug("没有该用户");
            return goToWelcome();
        }

        return showUserList();
    }




    /**
     * @Author 段连洁 [ manajay.dlj@gmail.com ]
     * @Date   02/08/2017 4:39 PM
     * @Method userDetail
     * @Params [request, model]
     * @Return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/userDetail")
    public ModelAndView userDetail (@RequestParam(value = "id", required = true,defaultValue = "1")
                                                HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        User user =  userService.getUser(Integer.parseInt(id));

        ModelAndView userView = new ModelAndView();
        userView.addObject("user",user);
        userView.setViewName("userView");
        return userView;
    }


    @RequestMapping("/userEdit")
    /**
     * @Author 段连洁 [ manajay.dlj@gmail.com ]
     * @Date   02/08/2017 4:40 PM
     * @Method userEdit
     * @Params [id]
     * @Return org.springframework.web.servlet.ModelAndView
     */
    public ModelAndView userEdit(int id){
        User user =  userService.getUser(id);

        ModelAndView userView = new ModelAndView();
        userView.addObject("user",user);
        userView.setViewName("userEdit");
        return userView;
    }

    @RequestMapping("/updateUser")
    /**
     * @Author 段连洁 [ manajay.dlj@gmail.com ]
     * @Date   02/08/2017 4:40 PM
     * @Method userUpdate
     * @Params [user]
     * @Return org.springframework.web.servlet.ModelAndView
     */
    public ModelAndView userUpdate(User user){
        userService.updateUser(user);

        return showUserList();
    }

    @RequestMapping("/userList")
    /**
     * @Author 段连洁 [ manajay.dlj@gmail.com ]
     * @Date   02/08/2017 4:40 PM
     * @Method showUserList
     * @Params []
     * @Return org.springframework.web.servlet.ModelAndView
     */
    public ModelAndView showUserList(){

        List<User> list = userService.getAllUsers();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("userListView");
        return modelAndView;
    }

}
