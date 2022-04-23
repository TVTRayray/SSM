package org.example.service;

import org.example.domain.Role;
import org.example.domain.User;

import java.util.List;

public interface UserService {
    List<User> list();



    void save(User user, long[] roleIds);

    void del(long userId);

    User login(String username, String password);
}
