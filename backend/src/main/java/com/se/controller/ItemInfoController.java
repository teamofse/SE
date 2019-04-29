package com.se.controller;

import com.se.entity.Goods;
import com.se.entity.GoodsInformation;
import com.se.entity.Users;
import com.se.result.Result;
import com.se.entity.GoodsInformation;
import com.se.result.ResultFactory;
import com.se.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Hashtable;
import java.util.Objects;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

@RestController
@RequestMapping("/api")
public class ItemInfoController {
    @Autowired
    private GoodsService goodsService;
    @CrossOrigin
    @RequestMapping(value = "/getiteminfopage", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public GoodsInformation getItemInfoPage(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));

        String itemId=request.getParameter("itemId");
        System.out.println(itemId);
        int itemid = parseInt(itemId);
//        Hashtable hashtable=new Hashtable();//存放要返回的数据
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        String account = (String)session.getAttribute("account");
        return goodsService.selectGoodsByItemId(itemid);

    }

}
