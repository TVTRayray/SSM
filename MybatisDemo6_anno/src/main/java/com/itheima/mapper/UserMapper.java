package com.itheima.mapper;

import com.itheima.domain.Order;
import com.itheima.domain.User;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Insert("insert into user values(#{id},#{username},#{password})")
    public void save(User user);

    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    public void update(User user);

    @Delete("delete from user where id=#{id}")
    public void delete(int id);

    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user where id=#{id}")
    public User findById(int id);

    @Select("select * from user")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    property = "orders",//要封装的属性名称
                    column = "id",//根据哪个字段去查询order表的数据
                    javaType = List.class,//要封装的实体类型
                    many = @Many(select = "com.itheima.mapper.OrderMapper.findByUid")
            )
    }
    )
    public List<User> findUserAndOrder();


    @Select("select * from user")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    property = "roles",//要封装的属性名称
                    column = "id",//
                    javaType = List.class,//要封装的实体类型
                    many = @Many(select = "com.itheima.mapper.RoleMapper.findByUserId")

            )
    }
    )
    public List<User> findUserAndRoleAll();
}
