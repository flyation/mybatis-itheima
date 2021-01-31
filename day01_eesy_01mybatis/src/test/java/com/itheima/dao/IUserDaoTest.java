package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class IUserDaoTest {

    @Test
    public void findAll() throws IOException {
        // 1.加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        // 3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        // 4.使用SqlSession对象创建Dao接口得的代理对象
        IUserDao mapper = session.getMapper(IUserDao.class);
        // 5.使用代理对象执行方法
        List<User> users = mapper.findAll();
        users.forEach(System.out::println);
        // 6.释放资源
        session.close();
        is.close();
    }
}
