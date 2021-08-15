package com.user.controller;

import com.book.pojo.Books;
import com.book.service.BookService;
import com.borrow.pojo.Borrow;
import com.borrow.service.BorrowService;
import com.user.pojo.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @Autowired
    @Qualifier("BorrowServiceImpl")
    private BorrowService borrowService;

    /**
     * 登陆提交 成功跳转到 主页面
     * @param userName
     * @param userPwd
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/judgeLogin")
    public String login(String userName, String userPwd , HttpSession session , Model model){
        // 向session记录用户身份信息
        String userRoot = "Administrator";
        List<User> users = userService.judgeUserLogin(userName , userPwd);
        List<User> admin = userService.judgeAdminLogin(userName , userPwd , userRoot);

        //登录失败 返回login界面
        if(users.size() == 0 && admin.size() == 0){
            return "login";
        }

        if(admin.size() != 0){
            session.setAttribute("userName", userName);
            String name=(String)session.getAttribute("userName");

            List<Books> list = bookService.popularBooks();
            model.addAttribute("bookList" , list);
            return "adminMain";
        }

        //登录成功 添加session(非管理员)
        else {
            session.setAttribute("userName", userName);
            String name=(String)session.getAttribute("userName");

            List<Borrow> list = borrowService.queryUserBorrow(userName);
            model.addAttribute("borrowList" , list);

            return "main";
        }

    }
}
