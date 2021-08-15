package com.borrow.service;

import com.borrow.mapper.BorrowMapper;
import com.borrow.pojo.Borrow;

import java.util.List;

public class BorrowServiceImpl implements BorrowService {
    //Service层 调用 Mapper层
    private BorrowMapper borrowMapper;


    public void setBorrowMapper(BorrowMapper borrowMapper) {
        this.borrowMapper = borrowMapper;
    }


    @Override
    public int addBorrow(Borrow borrow) {
        return borrowMapper.addBorrow(borrow);
    }

    @Override
    public Borrow queryBorrow(String userName, String bookName) {
        return borrowMapper.queryBorrow(userName, bookName);
    }

    @Override
    public int updateBookNum(int bookID) {
        return borrowMapper.updateBookNum(bookID);
    }

    @Override
    public List<Borrow> queryUserBorrow(String userName) {
        return borrowMapper.queryUserBorrow(userName);
    }

    @Override
    public int deleteUserBorrow(String userName, int bookID) {
        return borrowMapper.deleteUserBorrow(userName, bookID);
    }

    @Override
    public int returnBook(int bookID) {
        return borrowMapper.returnBook(bookID);
    }
}
