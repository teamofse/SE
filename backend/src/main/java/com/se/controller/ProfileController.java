package com.se.controller;

import com.se.entity.InfoDeal;
import com.se.entity.Users;
import com.se.entity.GoodsInformation;
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
//    @CrossOrigin
//    @ResponseBody
//    //根据卖家id查询交易信息
//    @RequestMapping(value = "/queryDealByBuyId", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
//    public List<Goods> dealQueryByBuyId(HttpServletRequest request, HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
//        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
//        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
//        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
//        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
//        String account = (String)session.getAttribute("account");
//        return profileService.queryByBuyIdService(account);
//    }
    @CrossOrigin
    @ResponseBody
    //根据id查询用户信息
    @RequestMapping(value = "/queryUserById", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Users userQueryById(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        String account = (String)session.getAttribute("account");
        System.out.println(session.getId());
        return profileService.queryByUserIdService(account);
    }
    @CrossOrigin
    @ResponseBody
    //根据用户id查询已卖出信息
    @RequestMapping(value = "/queryGoodBySoldId", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public List<GoodsInformation> goodQueryBySoldId(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        String account = (String)session.getAttribute("account");
        return profileService.queryBySoldStateService(1,account);
    }
    @CrossOrigin
    @ResponseBody
    //根据用户id查询未卖出信息
    @RequestMapping(value = "/queryGoodByOnSaleId", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public List<GoodsInformation> goodQueryByOnSaleId(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        String account = (String)session.getAttribute("account");
        return profileService.queryByOnSaleStateService(0,account);
    }

    @CrossOrigin
    @ResponseBody
    //根据用户id查询已收到信息
    @RequestMapping(value = "/queryGoodByArriveState", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public List<GoodsInformation> goodQueryByOnArriveState(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        String account = (String)session.getAttribute("account");
        return profileService.queryByArriveStateService(1,account);
    }

    @CrossOrigin
    @ResponseBody
    //根据用户id查询未收到信息
    @RequestMapping(value = "/queryGoodByOnTheWayState", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public List<GoodsInformation> goodQueryByOnTheWayState(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        String account = (String)session.getAttribute("account");
        return profileService.queryByOnTheWayStateService(0,account);
    }

    @CrossOrigin
    @ResponseBody
    //根据用户id查询收藏信息
    @RequestMapping(value = "/queryGoodByOnLikeState", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public List<GoodsInformation> goodQueryByOnLikeState(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        String account = (String)session.getAttribute("account");
        return profileService.queryByOnLikeStateService(1,account);
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

//        String account = (String)session.getAttribute("account");
        System.out.println(session.getId());
        hashtable.put("msg","修改成功");
        return ResultFactory.buildSuccessResult(hashtable);
    }
}
