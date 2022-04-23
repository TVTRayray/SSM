package org.example.service.impl;

import org.example.dao.RoleDao;
import org.example.domain.Role;
import org.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {


    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }



    @Override
    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return  roleList;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public void del(long roleId) {
       //delete delUserRoleRel
        roleDao.delUserRoleRel(roleId);
       //delete role
        roleDao.del(roleId);
    }




}
