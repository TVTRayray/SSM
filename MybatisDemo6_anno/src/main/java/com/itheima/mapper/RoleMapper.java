package com.itheima.mapper;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    @Select("SELECT * from sys_user_role ur,sys_role r where ur.roleId=r.id AND ur.userId=#{userId}")
    public List<Role> findByUserId(int userId);

}
