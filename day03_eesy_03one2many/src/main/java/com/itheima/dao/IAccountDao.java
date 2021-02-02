package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有账户
     */
    List<Account> findAll();

    /**
     * 查询所有账户同时包含用户信息
     */
    List<Account> findAllAccount();
}
