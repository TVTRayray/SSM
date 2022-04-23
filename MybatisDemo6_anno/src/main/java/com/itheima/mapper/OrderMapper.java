package com.itheima.mapper;

import com.itheima.domain.Order;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    //写法1
//    @Select("SELECT *, o.id oid, u.id uid FROM `user` u,`order` o where o.uid=u.id")
//    @Results({
//            @Result(column = "oid", property = "id"),
//            @Result(column = "ordertime", property = "ordertime"),
//            @Result(column = "total", property = "total"),
//            @Result(column = "uid", property = "user.id"),
//            @Result(column = "username", property = "user.username"),
//            @Result(column = "password", property = "user.password"),
//    })
//    public List<Order> findAll();

    //写法2
    @Select(" SELECT * FROM `order` ")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(
                    property = "user",//要封装的属性名称
                    column = "uid",//根据哪个字段去查询user表的数据
                    javaType = User.class,//要封装的实体类型
                    one = @One(select = "com.itheima.mapper.UserMapper.findById")
            )
    })
    public List<Order> findAll();


    @Select("SELECT * FROM `order` where uid=#{uid}")
    public List<Order> findByUid(int uid);
}
