package com.lj.spring.controller;

import com.lj.spring.bean.User;
import com.lj.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/gotoRegister")
    public ModelAndView gotoRegister () {
        ModelAndView userView = new ModelAndView();
        userView.setViewName("userRegisterView");
        return userView;
    }


    @RequestMapping("/userRegister")
    public ModelAndView userRegister (User user) {
        userService.addUser(user);

        return showUserList();
    }

    @RequestMapping("/userLogin")

    public ModelAndView userLogin(String name,String password) {
//        获取id
        User user = userService.getUserByUsername(name,password);
//        展示详情
        ModelAndView userView = new ModelAndView();
        userView.addObject("user",user);
        userView.setViewName("userView");
        return userView;
    }

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
    public ModelAndView userEdit(int id){
        User user =  userService.getUser(id);

        ModelAndView userView = new ModelAndView();
        userView.addObject("user",user);
        userView.setViewName("userEdit");
        return userView;
    }

    @RequestMapping("/updateUser")
    public ModelAndView userUpdate(User user){
        userService.updateUser(user);

        return showUserList();
    }

    @RequestMapping("/userList")
    public ModelAndView showUserList(){

        List<User> list = userService.getAllUsers();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("userListView");
        return modelAndView;
    }

}
