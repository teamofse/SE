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
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Hashtable;
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
        String sessionId=request.getParameter("sessionId");
        Hashtable hashtable=new Hashtable();//存放要返回的数据
        HttpSession session=request.getSession();//获取request请求里的session


        if(account==null){
            String message = String.format("登陆失败，详细信息[用户名为空]。");
            return ResultFactory.buildFailResult(message);
        }
        Users foundUser=usersService.selectUserByAccount(account);
        //System.out.println("account:"+account+" password:"+password);
        if (!Objects.equals(foundUser.getPassword(), password)) {
            String message = String.format("登陆失败，详细信息[用户名、密码信息不正确]。");
            return ResultFactory.buildFailResult(message);
        }
        session.setAttribute("account",account);
        session.setAttribute("password",password);
        System.out.println(session.getId());
        String msg="登陆成功";
        hashtable.put("msg",msg);
        hashtable.put("sessionId",session.getId());
        //hashtable.put("session",session);
        return ResultFactory.buildSuccessResult(hashtable);
    }
}
