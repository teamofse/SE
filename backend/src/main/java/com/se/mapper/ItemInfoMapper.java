package com.se.mapper;

import com.se.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ItemInfoMapper {

    @Select("SELECT * FROM users WHERE account = #{account}")
    Users Buying(@Param("account") String account);
}
