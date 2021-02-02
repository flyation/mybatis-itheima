package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有用户同时包含账户信息
     */
    List<User> findAll();

    /**
     * 根据id查询用户
     */
    User findUserById(Integer id);
}
