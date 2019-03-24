package com.se.service;


import com.se.entity.Test;
import com.se.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;
    public List<Test> queryById() {
        return testMapper.queryById();
    }

}
