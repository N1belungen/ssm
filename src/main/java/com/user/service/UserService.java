package com.user.service;

import com.user.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    /**
     * 注册用户
     * @param user
     * @return
     */
    int registerUser(User user);

    /**
     * 根据ID删除用户
     * @param userID
     * @return
     */
    int deleteUserById(String userID);

    /**
     * 更改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 查询全部用户
     * @return
     */
    List<User> queryAllUser();

    /**
     * 模糊查询用户
     * @param userName
     * @return
     */
    List<User> queryUserLike(String userName);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    User queryUser(String userName);

    /**
     * 根据用户名查询用户
     * @param userID
     * @return
     */
    User queryUserByID(String userID);

    /**
     * 验证用户登录
     * @param userName
     * @param userPwd
     * @return
     */
    List<User> judgeUserLogin(@Param("userName") String userName , @Param("userPwd") String userPwd);

    /**
     * 验证管理员登录
     * @param userName
     * @param userPwd
     * @return
     */
    List<User> judgeAdminLogin(@Param("userName") String userName , @Param("userPwd") String userPwd , @Param("userRoot")String userRoot);

    /**
     * 修改用户密码
     * @param userName
     * @param userPwd
     * @return
     */
    int updateUserPwd(@Param("userName") String userName , @Param("userPwd") String userPwd);
}
