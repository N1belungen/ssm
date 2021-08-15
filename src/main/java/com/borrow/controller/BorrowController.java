package com.borrow.controller;

import com.book.pojo.Books;
import com.book.service.BookService;
import com.borrow.pojo.Borrow;
import com.borrow.service.BorrowService;
import com.borrow.utils.DateUtils;

import com.user.pojo.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BorrowController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @Autowired
    @Qualifier("BorrowServiceImpl")
    private BorrowService borrowService;

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;


    /**
     * 跳转到 书籍借阅 页面,显示所有书籍
     *
     * @param bookName
     * @param model
     * @return
     */
    @RequestMapping("/bookNameQuery")
    public String queryBookName(String bookName, Model model) {
        System.out.println("bookName =>" + bookName);
        List<Books> list = bookService.queryBookLike(bookName);
        model.addAttribute("bookList", list);
        return "bookBorrow";
    }

    /**
     * 通过当前登录的用户和点击对应的按钮进行信息提示
     *
     * @param bookID
     * @param userName
     * @return
     */
    @ResponseBody
    @RequestMapping("/toBookBorrow")
    public String toBookBorrow(int bookID, String userName) {
        String str = "";
        Books books = bookService.queryBookById(bookID);
        System.out.println("bookID ==>" + bookID);
        System.out.println("userName ==>" + userName);
        String borrowTime = DateUtils.getBorrowDate();
        str = "{\"bookName\":\"" + books.getBookName() + "\","
                + "\"userName\":\"" + userName + "\","
                + "\"borrowTime\":\"" + borrowTime + "\"}";
        System.out.println("str ==>" + str);
        return str;
    }

    /**
     * 选择借阅时间后 通过ajax刷新还书时间
     *
     * @param dayMount
     * @return
     */
    @ResponseBody
    @RequestMapping("/bookBorrowTime")
    public String bookBorrowTime(int dayMount) {
        String returnTime = DateUtils.getReturnDate(dayMount);
        return returnTime;
    }

    /**
     * 进行 书籍借阅操作 完成后 跳转回主页面
     * @param borrow
     * @param attributes
     * @return
     */
    @RequestMapping("/bookBorrowAdd")
    public String bookBorrowAdd(Borrow borrow , RedirectAttributes attributes) {
        String userName = borrow.getUserName();
        User user= userService.queryUser(userName);
        String userID = user.getUserID();

        String bookName = borrow.getBookName();
        Books books = bookService.queryBookId(bookName);
        int bookID = books.getBookID();

        borrow.setUserID(userID);
        borrow.setBookID(bookID);

        Borrow query = borrowService.queryBorrow(userName, bookName);

        if(query != null){
            attributes.addFlashAttribute("bookBorrowAdd","你已经借过这本书了!!!");
            return "main";
        }

        System.out.println("borrow =>" + borrow);
        int addBorrow = borrowService.addBorrow(borrow);
        if(addBorrow == 0){
            attributes.addFlashAttribute("bookBorrowAdd","借阅失败!!!");
        }
        borrowService.updateBookNum(bookID);
        attributes.addFlashAttribute("bookBorrowAdd","借阅成功!!!");
        return "main";

    }
}