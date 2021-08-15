package com.book.controller;

import com.book.pojo.Books;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    /**
     * 查询全部书籍
     * @param model
     * @return
     */
    @RequestMapping("/bookList")
    public String bookList(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("bookList" , list);
        return "bookList";
    }

    /**
     * 添加书籍
     * @return
     */
    @RequestMapping("/toBookAdd")
    public String toAddBook(){
        return "bookAdd";
    }

    /**
     * 添加书籍的请求
     * @param books
     * @return
     */
    @RequestMapping("/bookAdd")
    public String addBook(Books books){
        System.out.println("addBook => "+books);
        bookService.addBook(books);
        //重定向请求
        return "redirect:/adminMain";
    }

    /**
     * 修改书籍
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toBookUpdate/{bookId}")
    public String toUpdateBook(@PathVariable("bookId")int id , Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("queryBooks" , books);
        return "bookUpdate";
    }

    /**
     * 修改书籍的请求
     * @param books
     * @return
     */
    @RequestMapping("/bookUpdate")
    public String updateBook(Books books){
        System.out.println("updateBook => "+books);
        bookService.updateBook(books);
        return "redirect:/book/bookList";
    }

    /**
     * 删除书籍
     * @param id
     * @return
     */
    @RequestMapping("/bookDelete")
    public String deleteBook(int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/bookList";
    }

    /**
     * 展示最热门的十本书籍
     * 按照 借阅书籍数量 > 书籍数量 > 书籍名称 的顺序进行 降序(desc)排序
     * @return
     */
    @ResponseBody
    @RequestMapping("/popularBooks")
    public String queryBookName(){
        String msg = "[";
        String str = "";

        List<Books> list = bookService.popularBooks();
        for (int i = 0; i < list.size(); i++) {
            Books books = list.get(i);

            str =    "{\"bookID\":\"" + books.getBookID() + "\","
                    + "\"bookName\":\"" + books.getBookName() + "\","
                    + "\"bookCounts\":\"" + books.getBookCounts() + "\","
                    + "\"bookBorrow\":\"" + books.getBookBorrow() + "\","
                    + "\"detail\":\"" + books.getDetail() + "\"}";

            msg = msg + str;
        }
            msg = msg + "]";
        System.out.println(msg);
        return "msg";
    }


}
