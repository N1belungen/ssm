package com.borrow.mapper;

import com.borrow.pojo.Borrow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BorrowMapper {

    /**
     * 添加借阅信息
     * @param borrow
     * @return
     */
    int addBorrow(Borrow borrow);

    /**
     * 查阅用户是否借阅过该书籍
     * @param userName
     * @param bookName
     * @return
     */
    Borrow queryBorrow(@Param("userName")String userName , @Param("bookName") String bookName);


    /**
     * 借阅书籍 借阅书籍 + 1
     * @param bookID
     * @return
     */
    int updateBookNum(int bookID);

    /**
     * 根据用户名进行查阅已借阅的书籍
     * @param userName
     * @return
     */
    List<Borrow> queryUserBorrow(String userName);

    /**
     * 还书 删除记录
     * @param userName
     * @param bookID
     * @return
     */
    int deleteUserBorrow(@Param("userName")String userName , @Param("bookID") int bookID);

    /**
     * 归还书籍 借阅书籍 - 1
     * @param bookID
     * @return
     */
    int returnBook(int bookID);
}
