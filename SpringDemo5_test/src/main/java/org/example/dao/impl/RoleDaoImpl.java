package org.example.dao.impl;

import org.example.dao.RoleDao;
import org.example.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values(?,?,?)",null,role.getRoleName(),role.getRoleDesc());
    }

    @Override
    public List<Role> findRoleByUserId(Long id) {
        List<Role> roles = jdbcTemplate.query("select * from  sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId=?", new BeanPropertyRowMapper<Role>(Role.class), id);
        return  roles;
    }


    @Override
    public void del(long roleId) {
        jdbcTemplate.update("delete from sys_role where id=?",roleId);
    }

    @Override
    public void delUserRoleRel(long roleId) {
        jdbcTemplate.update("delete from sys_user_role where roleId=?",roleId);
    }
}
