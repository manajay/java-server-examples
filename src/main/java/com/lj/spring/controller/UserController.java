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
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//请求–>DispatcherServlet–>HandlerMapping–>Controller组件（变化）–>ViewResolver–>JSP组件（变化）

@Controller
@RequestMapping("/api")

public class UserController {

    @Autowired
    private UserService userService;

    static private Logger log = Logger.getLogger(UserController.class.getName());

    @RequestMapping("/gotoRegister")

    public ModelAndView gotoRegister () {
        ModelAndView userView = new ModelAndView();
        userView.setViewName("userRegisterView");
        return userView;
    }

    @RequestMapping("/goToWelcome")

    public ModelAndView  goToWelcome(){
        ModelAndView userView = new ModelAndView();
        userView.setViewName("index");
        return userView;
    }


    @RequestMapping("/userRegister")

    public ModelAndView userRegister (User user) {
        userService.addUser(user);

        return showUserList();
    }

    @RequestMapping("/userLogin")
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





    @RequestMapping("/userDetail")
    public ModelAndView userDetail (@RequestParam(value = "id",defaultValue = "1")
                                                HttpServletRequest request) {
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

    public ModelAndView userUpdate(HttpServletRequest req){

        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String id  = req.getParameter("id");
        String name = req.getParameter("name");
        String detail = req.getParameter("detail");
        String age = req.getParameter("age");

        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setAge(Integer.parseInt(age));
        user.setName(name);
        user.setDetail(detail);

        userService.updateUser(user);
        return showUserList();
    }

    @RequestMapping("/updateUser0")

    public ModelAndView userUpdate0(User user){
        log.debug(user);

        userService.updateUser(user);
        return showUserList();
    }

    @RequestMapping("/userDelete")
    public ModelAndView userDelete(int id) {
        userService.deleteUser(id);
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
