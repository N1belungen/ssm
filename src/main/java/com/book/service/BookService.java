package com.book.service;

import com.book.pojo.Books;

import java.util.List;

public interface BookService {

    /**
     * 添加书籍
     * @param books
     * @return
     */
    int addBook(Books books);

    /**
     * 根据ID删除书籍
     * @param id
     * @return
     */
    int deleteBookById(int id);

    /**
     * 更新书籍
     * @param books
     * @return
     */
    int updateBook(Books books);

    /**
     * 根据ID查询书籍
     * @param id
     * @return
     */
    Books queryBookById(int id);

    /**
     * 查询全部书籍
     * @return
     */
    List<Books> queryAllBook();

    /**
     * 根据名字 模糊 查询书籍
     * @param bookName
     * @return
     */
    List<Books> queryBookLike(String bookName);

    /**
     * 根据名字 查询书籍
     * @param bookName
     * @return
     */
    Books queryBookId(String bookName);

    /**
     * 展示最热门的十本书籍
     * 按照 借阅书籍数量 > 书籍数量 > 书籍名称 的顺序进行 降序(desc)排序
     * @return
     */
    List<Books> popularBooks();
}
