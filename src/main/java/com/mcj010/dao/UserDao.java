package com.mcj010.dao;

import com.mcj010.bean.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    @Select("select * from user where id = #{id}")
    public User selectUserById(Integer id);

}
