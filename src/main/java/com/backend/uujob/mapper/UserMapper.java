package com.backend.uujob.mapper;

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
    /**
     * 查询所有数据
     * @return 所有用户数据的json
     */
    @Select("select * from seeker")
    List<User> findAll();

    //更新一条数据
    @Update("update seeker set name = #{name}, password = #{password}, id = #{id}, account = #{account}, phone = #{phone}, character = #{character} where id = #{id}")
    int update(User user);

    @Insert("insert into seeker(id,account,password,name,phone,character) values (#{id},#{account},#{password},#{name},#{phone},#{character})")
    int insert(User user);

}
