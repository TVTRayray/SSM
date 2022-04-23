package org.example.Dao.Impl;

import org.example.Dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
//<bean id="userDao" class="org.example.Dao.Impl.UserDaoImpl"/>
public class UserDaoImpl implements UserDao {
    @Override
    public void run() {
        System.out.println("running method....");
    }

}
