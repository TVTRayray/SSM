package org.example.Dao.Impl;

import org.example.Dao.UserDao;
import org.example.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 *  普通类型、集合类型的注入
 */
public class UserDaoImpl2 implements UserDao {
    //普通类型
    private String username;
    private int age;
    //集合类型
    private List<String> list;
    private Map<String, User> userMap;
    private Properties properties;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void run() {
        System.out.println("running method....");
        System.out.println(username);
        System.out.println(age);
        System.out.println(list);
        System.out.println(userMap);
        System.out.println(properties);
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
