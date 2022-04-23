package org.example.dao;

import org.example.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();



    long save(User user);

    void saveUserRel(Long userId, long[] roleIds);

    void delUserRoleRel(long userId);

    void del(long userId);

    User findByUsernameAndPassword(String username, String password);
}
