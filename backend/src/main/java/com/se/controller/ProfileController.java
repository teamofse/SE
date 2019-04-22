package com.se.controller;

import com.se.entity.InfoDeal;
import com.se.entity.Users;
import com.se.entity.Goods;
import com.se.result.Result;
import com.se.result.ResultFactory;
import com.se.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")

public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @CrossOrigin
    @ResponseBody
    //查询所有商品信息
    @RequestMapping(value="/queryDealById", method= RequestMethod.GET, produces="application/json; charset=UTF-8")
    public List<InfoDeal> dealQueryById(){
        return profileService.queryByIdService();
    }
    @CrossOrigin
    @ResponseBody
    //根据卖家id查询交易信息
    @RequestMapping("/queryDealByBuyId")
    public List<Goods> dealQueryByBuyId() {
        return profileService.queryByBuyIdService("cyy");
    }
    @CrossOrigin
    @ResponseBody
    //根据id查询用户信息
    @RequestMapping("/queryUserById")
    public Users userQueryById() {
        return profileService.queryByUserIdService("cyy");
    }
    @CrossOrigin
    @ResponseBody
    //根据用户id查询已卖出信息
    @RequestMapping("/queryGoodBySoldId")
    public List<Goods> goodQueryBySoldId() {
        return profileService.queryBySoldStateService("sold","cyy");
    }
    @CrossOrigin
    @ResponseBody
    //根据用户id查询未卖出信息
    @RequestMapping("/queryGoodByOnSaleId")
    public List<Goods> goodQueryByOnSaleId() {
        return profileService.queryByOnSaleStateService("onsale","cyy");
    }

    //根据id修改商品信息
//    @CrossOrigin
//    @ResponseBody
//    @RequestMapping(value="/updateAddr", method= RequestMethod.PUT, produces="application/json; charset=UTF-8")
//    public Users addrUpdate(String account, String user_addr) {
//        profileService.updateAddrService(account,user_addr);
//        return profileService.queryByUserIdService(account);
//    }

    @CrossOrigin
    @RequestMapping(value = "/updateAddrs", method = RequestMethod.PUT, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result updateAddr(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));

        String account=request.getParameter("account");
        String user_addr=request.getParameter("user_addr");
        Hashtable hashtable=new Hashtable();//存放要返回的数据
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session

        if(account==null||user_addr==null){
            String message = String.format("地址修改失败，详细信息[地址为空]。");
            return ResultFactory.buildFailResult(message);
        }
//        Users foundUser=profileService.updateAddrService(account, user_addr);
        profileService.updateAddrService(user_addr,account);
        System.out.println("account:"+account+" user_addr:"+user_addr);

        session.setAttribute("account",account);
        System.out.println(session.getId());
        hashtable.put("msg","修改成功");
        return ResultFactory.buildSuccessResult(hashtable);
    }
}
