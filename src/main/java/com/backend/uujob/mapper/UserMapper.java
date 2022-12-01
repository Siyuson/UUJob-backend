package com.backend.uujob.mapper;

import com.backend.uujob.controller.dto.UserPasswordDTO;
import com.backend.uujob.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import  java.util.List;

/**
 * 用户功能接口
 *
 * @author Siyuson
 */
public interface UserMapper extends BaseMapper<User> {
    int updatePassword(@Param("userPasswordDTO") UserPasswordDTO userPasswordDTO);
//    @Select("select * from user")
//    List<User> findAll();
//
//    //更新一条数据
//    @Update("update user set name = #{name}, password = #{password}, id = #{id}, account = #{account}, phone = #{phone}, role = #{role} where id = #{id}")
//    int update(User user);
//
//    @Insert("insert into user(id,account,password,name,phone,role) values (#{id},#{account},#{password},#{name},#{phone},#{role})")
//    int insert(User user);
//
//    int updatePassword(@Param("userPasswordDTO") UserPasswordDTO userPasswordDTO);
}
