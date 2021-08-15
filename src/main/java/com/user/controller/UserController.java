package com.user.controller;

import com.book.pojo.Books;
import com.borrow.utils.SessionUtils;
import com.user.pojo.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    /**
     * 跳转到 个人用户信息 界面
     * @return
     */
    @RequestMapping("/userInfo")
    public String userInfo(){
        return "userInfo";
    }

    /**
     * 从数据库中读取 用户个人信息
     * @param userName
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryUserInfo")
    public String queryUserInfo(String userName){
        String info = "";
        User user = userService.queryUser(userName);
        info =    "{\"userID\":\"" + user.getUserID() + "\","
                + "\"userName\":\"" + userName + "\","
                + "\"userRoot\":\"" + user.getUserRoot() + "\"}";
        return info;
    }

    /**
     * 跳转到 更改用户密码 界面
     * @return
     */
    @RequestMapping("/userPwdUpdate")
    public String userPwdUpdate(){
        return "userPwdUpdate";
    }

    @RequestMapping("/toUserPwdUpdate")
    public String toUserPwdUpdate(String userPwd , String userNewPwd){
        SessionUtils sessionUtils = new SessionUtils();
        Object userName = sessionUtils.getSession().getAttribute("userName");

        List<User> users = userService.judgeUserLogin((String) userName , userPwd);
        if(users.size() != 0)
        userService.updateUserPwd((String) userName , userNewPwd);
        return "main";
    }

    /**
     * 展示用户信息list
     * @param model
     * @return
     */
    @RequestMapping("/userList")
    public String goAdminMain(Model model){
        List<User> list = userService.queryAllUser();
        model.addAttribute("userList" , list);
        return "userList";
    }

    /**
     * 修改用户信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toUserUpdate/{userID}")
    public String toUpdateBook(@PathVariable("userID")String id , Model model){
        User users = userService.queryUserByID(id);
        model.addAttribute("queryUser" , users);
        return "userUpdate";
    }

    @RequestMapping("/userUpdate")
    public String updateUser(User user){
        System.out.println("updateBook => "+user);
        userService.updateUser(user);
        return "redirect:/userList";
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @RequestMapping("/userDelete")
    public String deleteUser(String id) {
        System.out.println(id);
        userService.deleteUserById(id);
        return "redirect:/userList";
    }
}
