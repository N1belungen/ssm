package com.borrow.controller;

import com.book.service.BookService;
import com.borrow.pojo.Borrow;
import com.borrow.service.BorrowService;
import com.borrow.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ReturnController {
    @Autowired
    @Qualifier("BorrowServiceImpl")
    private BorrowService borrowService;
    private BookService bookService;


    /**
     * 获取当前用户所借阅的书籍
     * @param model
     * @return
     */
    @RequestMapping("/bookReturn")
    public String bookList(Model model){

        SessionUtils sessionUtils = new SessionUtils();
        Object userName = sessionUtils.getSession().getAttribute("userName");

        List<Borrow> list = borrowService.queryUserBorrow((String) userName);
        System.out.println(userName);

        model.addAttribute("bookList" , list);
        return "bookReturn";
    }



    /**
     * 进行还书操作
     * @param id
     * @return
     */
    @RequestMapping("/borrowDelete")
    public String deleteBook(int id) {
        SessionUtils sessionUtils = new SessionUtils();
        Object userName = sessionUtils.getSession().getAttribute("userName");

        int flag = borrowService.deleteUserBorrow((String) userName , id);
        if(flag != 0){
            borrowService.returnBook(id);
        }

        return "redirect:/bookReturn";
    }
}
