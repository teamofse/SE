package com.se.controller;


import com.se.entity.Test;
import com.se.entity.Users;
import com.se.result.Result;
import com.se.result.ResultFactory;
import com.se.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UsersService usersService;

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result testLogin(HttpServletRequest request) {
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        //System.out.println("account:"+account+" password:"+password);
        if (!Objects.equals("cyy", account) || !Objects.equals("1899", password)) {
            String message = String.format("登陆失败，详细信息[用户名、密码信息不正确]。");
            return ResultFactory.buildFailResult(message);
        }
        return ResultFactory.buildSuccessResult("登陆成功。");
    }
}
