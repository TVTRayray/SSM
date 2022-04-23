package org.example.dao.impl;

import org.example.dao.RoleDao;
import org.example.dao.UserDao;
import org.example.domain.Role;
import org.example.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        return  userList;
    }

    @Override
    public long save(final User user) {
        //jdbcTemplate.update("insert  into sys_user values(?,?,?,?,?)",null,user.getUsername(),user.getEmail(),user.getPassword(),user.getPhoneNum());
        //创建PrepareStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                //使用原始JDBC完成
                PreparedStatement preparedStatement = connection.prepareStatement("insert  into sys_user values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setObject(2,user.getUsername());
                preparedStatement.setObject(3,user.getEmail());
                preparedStatement.setObject(4,user.getPassword());
                preparedStatement.setObject(5,user.getPhoneNum());
                return preparedStatement;
            }
        };
        //创建keyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator,keyHolder);
        //获得生成的主键
        long userId = keyHolder.getKey().longValue();

        return userId; //返回当前用户的id 该id是数据库自动生成的
    }

    @Override
    public void saveUserRel(Long userId, long[] roleIds) {

        for (long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values(?,?)",userId,roleId);
        }

    }

    @Override
    public void delUserRoleRel(long userId) {
        jdbcTemplate.update("delete  from sys_user_role where userId=?",userId);
    }

    @Override
    public void del(long userId) {
        jdbcTemplate.update("delete  from sys_user where id=?",userId);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) throws EmptyResultDataAccessException {
        //处理空数据集异常
        User user =  jdbcTemplate.queryForObject("select * from sys_user where username=? and password=?", new BeanPropertyRowMapper<User>(User.class), username, password);
        return  user;
    }


}
