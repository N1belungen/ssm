package com.book.service;

import com.book.mapper.BookMapper;
import com.book.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{
    //Service层 调用 Mapper层
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public List<Books> queryBookLike(String bookName) {
        return bookMapper.queryBookLike(bookName);
    }

    @Override
    public Books queryBookId(String bookName) {
        return bookMapper.queryBookId(bookName);
    }

    @Override
    public List<Books> popularBooks() {
        return bookMapper.popularBooks();
    }
}
