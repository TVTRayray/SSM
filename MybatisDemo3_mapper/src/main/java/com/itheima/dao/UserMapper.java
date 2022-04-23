package com.itheima.dao;

import com.itheima.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {

    public List<User> findAll() throws IOException;
    public List<User> findByCondition(User user) throws IOException;
    public List<User> findByIds(List<Integer> ids) throws IOException;


}
