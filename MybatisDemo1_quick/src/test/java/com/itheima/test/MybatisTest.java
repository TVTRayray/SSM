package com.itheima.test;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *  mybatis快速入门：
 *                  1.编写实体类
 *                  2.创建实体对应的数据库表
 *                  3.编写映射文件UserMapper.xml(只针对user的映射文件，还可以配其他的，比如说role)
 *                  4.编写核心文件SqlConfig.xml(设置数据源、导入映射文件)
 *                  5.编写测试类
 */
public class MybatisTest {

    @Test
    //1.查询所有
    public void test1() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //打印数据
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }
    @Test
    //2.查询单个用户
    public void test2() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作，参数：namespace+id
        User user = sqlSession.selectOne("userMapper.findById", 1);
        //打印数据
        System.out.println(user);
        //释放资源
        sqlSession.close();
    }
    @Test
    //3.插入
    public void test3() throws IOException {
        //模拟对象
        User user = new User();

        user.setUsername("ggBoy");
        user.setPassword("96432");

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("userMapper.save", user);

        //mybatis执行更新操作，提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //4.更新
    public void test4() throws IOException {
        //模拟对象
        User user = new User();
        user.setId(5);
        user.setUsername("tainqi");
        user.setPassword("99999");

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("userMapper.update",user);

        //mybatis执行更新操作，提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    //5.删除
    public void test5() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("userMapper.delete",7);
        sqlSession.commit();
        sqlSession.close();
    }
}
