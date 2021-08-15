package com.user.controller;

import com.book.pojo.Books;
import com.book.service.BookService;
import com.borrow.pojo.Borrow;
import com.borrow.service.BorrowService;
import com.borrow.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HeaderController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @Autowired
    @Qualifier("BorrowServiceImpl")
    private BorrowService borrowService;

    /**
     * 点击首页 跳转回 主页面
     * @return
     */
    @RequestMapping("/main")
    public String goMain(Model model){
        SessionUtils sessionUtils = new SessionUtils();
        Object userName = sessionUtils.getSession().getAttribute("userName");

        List<Borrow> list = borrowService.queryUserBorrow((String) userName);
        model.addAttribute("borrowList" , list);
        return "main";
    }

    /**
     * 点击首页 跳转回 主页面
     * @return
     */
    @RequestMapping("/adminMain")
    public String goAdminMain(Model model){
        List<Books> list = bookService.popularBooks();
        model.addAttribute("bookList" , list);

        return "adminMain";
    }

    /**
     * 跳转到 书籍借阅 页面 并执行一次查询所有书籍
     * @param model
     * @return
     */
    @RequestMapping("/borrow")
    public String goCheckout(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("bookList" , list);
        return "bookBorrow";
    }
}
