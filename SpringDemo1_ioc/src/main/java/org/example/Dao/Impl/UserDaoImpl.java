package org.example.Dao.Impl;

import org.example.Dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void run() {
        System.out.println("running method....");
    }
    public void init(){
        System.out.println("init method...");
    }
    public void destroy(){
        System.out.println("destroy method...");
    }
}
