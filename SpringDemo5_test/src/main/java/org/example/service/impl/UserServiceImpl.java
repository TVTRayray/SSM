package org.example.service.impl;

import org.example.dao.RoleDao;
import org.example.dao.UserDao;
import org.example.domain.Role;
import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList= userDao.findAll();
        //在返回之前，封装userList中的每一个User的roles数据
        for (User user : userList) {
            Long id = user.getId();
            //将id作为参数，查询当前user的role对象集合
            List<Role> roles =  roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, long[] roleIds) {
        //第一步，向sys_user表中存储数据
        long userId = userDao.save(user);

        //第二步，向sys_user_role表中存储多条数据
        userDao.saveUserRel(userId,roleIds);
    }

    @Override
    public void del(long userId) {
        //delete s_u_r
        userDao.delUserRoleRel(userId);
        //delete s_u
        userDao.del(userId);
    }

    @Override
    public User login(String username, String password) {
        try {
            User user = userDao.findByUsernameAndPassword(username,password);
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }


}
