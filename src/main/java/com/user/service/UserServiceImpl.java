package com.user.service;

import com.user.mapper.UserMapper;
import com.user.pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    //Service层 调用 Mapper层
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int registerUser(User user) {
        return userMapper.registerUser(user);
    }

    @Override
    public int deleteUserById(String userID) {
        return userMapper.deleteUserById(userID);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public List<User> queryUserLike(String userName) {
        return userMapper.queryUserLike(userName);
    }

    @Override
    public User queryUser(String userName) {
        return userMapper.queryUser(userName);
    }

    @Override
    public User queryUserByID(String userID) {
        return userMapper.queryUserByID(userID);
    }

    @Override
    public List<User> judgeUserLogin(String userName, String userPwd) {
        return userMapper.judgeUserLogin(userName , userPwd);
    }

    @Override
    public List<User> judgeAdminLogin(String userName, String userPwd, String userRoot) {
        return userMapper.judgeAdminLogin(userName, userPwd, userRoot);
    }

    @Override
    public int updateUserPwd(String userName, String userPwd) {
        return userMapper.updateUserPwd(userName, userPwd);
    }
}
