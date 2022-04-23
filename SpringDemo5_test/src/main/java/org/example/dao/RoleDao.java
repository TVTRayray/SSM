package org.example.dao;

import org.example.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(Long id);

    void del(long roleId);

    void delUserRoleRel(long roleId);
}
