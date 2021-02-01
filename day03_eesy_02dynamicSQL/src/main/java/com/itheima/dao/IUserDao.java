package com.itheima.dao;

import com.itheima.domain.QueryVo;
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

    /**
     * 根据条件查询
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据QueryVo中的id集合查询
     */
    List<User> findUserInIds(QueryVo vo);
}
