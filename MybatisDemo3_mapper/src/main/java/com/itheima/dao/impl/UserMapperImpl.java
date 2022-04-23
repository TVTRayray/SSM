package com.itheima.dao.impl;//package com.itheima.dao.impl;
//
//import com.itheima.dao.UserMapper;
//import com.itheima.domain.User;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
//public class UserMapperImpl implements UserMapper {
//    @Override
//    public List<User> findAll() throws IOException {
//
//        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<User> userList = sqlSession.selectList("userMapper.findAll");
//        return  userList;
//
//    }
//}
