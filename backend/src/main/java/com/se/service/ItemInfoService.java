package com.se.service;

import com.se.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemInfoService {
    @Autowired
    private com.se.mapper.UsersMapper UsersMapper;

    public Users selectUserByAccount(String account) {
        return UsersMapper.findUserByAccount(account);
    }

}
