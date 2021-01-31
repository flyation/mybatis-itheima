package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有
     */
    List<User> findAll();

    /**
     * 保存
     */
    void save(User user);

    /**
     * 删除
     */
    void delete(Integer id);
}
