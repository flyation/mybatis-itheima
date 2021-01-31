package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class IUserDaoTest {

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
        IUserDao mapper = session.getMapper(IUserDao.class);
        // 5.使用代理对象执行方法
        List<User> users = mapper.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public void save() {
        User user = new User().setUsername("张三6").setBirthday(new Date()).setSex("男").setAddress("人民公园");
        System.out.println("保存前" + user);
        IUserDao mapper = session.getMapper(IUserDao.class);
        mapper.save(user);
        System.out.println("保存后" + user);
    }

    @Test
    public void delete() {
        IUserDao mapper = session.getMapper(IUserDao.class);
        mapper.delete(52);
    }
}
