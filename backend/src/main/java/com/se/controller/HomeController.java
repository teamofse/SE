package com.se.controller;

import com.se.entity.Goods;

import com.se.entity.GoodsInformation;
import com.se.result.Result;
import com.se.result.ResultFactory;
import com.se.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private GoodsService goodsService;

    @CrossOrigin
    @ResponseBody
    //查询所有商品信息
    @RequestMapping(value = "/queryGoodsById", method= RequestMethod.GET, produces="application/json; charset=UTF-8")
    public List<Goods> goodsQueryById(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
//        HttpSession session=request.getSession();
        return goodsService.queryByIdService();
    }

    @CrossOrigin
    @ResponseBody
    //根据名字查询商品信息
    @RequestMapping("/queryGoodsByTitle")
    public List<Goods> goodsQueryByTitle() {
        return goodsService.queryByTitleService("朱一龙");
    }

    @CrossOrigin
    @ResponseBody
    //插入商品信息
    @RequestMapping("/insertGoods")
    public List<Goods> goodsInsert(){
        goodsService.insertService(50, "朱一龙", 300, "bbb", "ccc", 5);
        return goodsService.queryByIdService();
    }

    @CrossOrigin
    @RequestMapping(value = "/updateGoods", method = RequestMethod.PUT, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result updateAddr(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));

        String id_string=request.getParameter("id");
        int id = Integer.parseInt(id_string);
        String title=request.getParameter("title");
        String star_string=request.getParameter("star");
        int star = Integer.parseInt(star_string);
        String name=request.getParameter("name");
        String city=request.getParameter("city");
        String hot_string=request.getParameter("hot");
        int hot = Integer.parseInt(hot_string);

        Hashtable hashtable=new Hashtable();//存放要返回的数据
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session

        if(id==' ' || title==null || star==' ' || name==null || city==null ||hot==' '){
            String message = String.format("热度修改失败");
            return ResultFactory.buildFailResult(message);
        }
//        Users foundUser=profileService.updateAddrService(account, user_addr);
        goodsService.updateService(id, title, star, name, city, hot);
        System.out.println("id:"+id+" title:"+title+" star:"+star+" name"+name+" city"+city+" hot"+hot);

        //session.setAttribute("account",account);
        System.out.println(session.getId());
        hashtable.put("msg","修改成功");
        return ResultFactory.buildSuccessResult(hashtable);
    }

    @CrossOrigin
    @ResponseBody
    //根据id删除商品信息
    @RequestMapping("/deleteGoods")
    public String goodsDelete() {
        goodsService.deleteService(3);
        return "OK";
    }

}
