package com.user.controller;

import com.user.pojo.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.user.utils.IDUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    /**
     * 跳转到 用户注册 界面
     * @return
     */
    @RequestMapping("/index")
    public String toRegister(){
        return "register";
    }

    /**
     * 注册用户的请求
     * @param user
     * @return
     */
    @RequestMapping("/registerUser")
    public String register(User user){
        user.setUserID(IDUtils.getId());
        user.setUserRoot("Visitor");
        System.out.println(user);

        userService.registerUser(user);

        return "login";
    }

    /**
     * 验证用户名和密码是否重复
     * @param userName
     * @return
     */
    @ResponseBody
    @RequestMapping("/judgeRegister")
    public String judgeUserName(String userName){
        User users = userService.queryUser(userName);
        System.out.println("user =>" + users);
        //users存在数据 即数据库中存在相同用户名
        if(users != null)
            return "{\"msg\":\"false\"}";
        else
            return "{\"msg\":\"true\"}";
    }



}
