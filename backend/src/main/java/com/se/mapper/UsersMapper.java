package com.se.mapper;

import com.se.entity.Test;
import com.se.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UsersMapper {

    @Select("SELECT * FROM users WHERE account = #{account}")
    Users findUserByAccount(@Param("account") String account);

    @Select("SELECT * FROM users WHERE account = #{account} and password=#{password}")
    Users filterByAccountAndPassword(@Param("account") String account, @Param("password") String password);

    @Insert("INSERT INTO users (account,password,user_tel) VALUES (#{account},#{password},#{telephone});")
    Users insertUserInfoIntoUsers(@Param("account") String account,@Param("password") String password,@Param("telephone") String telephone);
}
