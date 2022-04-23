package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    private UserMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //传入布尔参数，会默认提交事务，不需要手动操作
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("二次元");
        user.setPassword("123456");
        mapper.save(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUsername("二次元");
        user.setPassword("1234");
        mapper.update(user);
    }

    @Test
    public void testDelete() {
        mapper.delete(5);
    }

    @Test
    public void testFindAll() {
//        List<User> userList = mapper.findAll();
//        List<User> userList = mapper.findUserAndOrder();
        List<User> userList = mapper.findUserAndRoleAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindById() {
        User user = mapper.findById(7);
        System.out.println(user);
    }


}
