package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class IAccountDaoTest {

    private InputStream is;
    private SqlSession session;

    @Before
    public void init() throws IOException {
        // 1.加载配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        // 3.使用工厂生产SqlSession对象
        session = factory.openSession();
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        // 6.释放资源
        session.close();
        is.close();
    }

    @Test
    public void findAll() {
        // 4.使用SqlSession对象创建Dao接口得的代理对象
        IAccountDao mapper = session.getMapper(IAccountDao.class);
        // 5.使用代理对象执行方法
        List<Account> accounts = mapper.findAll();
        accounts.forEach(System.out::println);
    }

    @Test
    public void findAllAccount() {
        // 4.使用SqlSession对象创建Dao接口得的代理对象
        IAccountDao mapper = session.getMapper(IAccountDao.class);
        // 5.使用代理对象执行方法
        List<Account> accounts = mapper.findAllAccount();
        accounts.forEach(System.out::println);
    }
}
