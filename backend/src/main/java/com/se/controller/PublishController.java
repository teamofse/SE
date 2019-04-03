package com.se.controller;

import com.se.entity.GoodsInformation;
import com.se.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PublishController {
    @Autowired
    private GoodsService goodsService;

    //发布时插入商品信息
    /*@RequestMapping("/insertGoodsInformation")
    private List<GoodsInformation> goodsinformationInsert(){
        goodsService.insert_Service(0, "11", 400, "2",  10 );
       return goodsService.query_ByIdService();
    }*/

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value="/insertGoodsInformation", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    private List<GoodsInformation> goodsinformationInsert(HttpServletRequest request, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));

        String goods_name=request.getParameter("goods_name");
        int price=Integer.valueOf(request.getParameter("price"));
        String goods_detail=request.getParameter("goods_detail");
        int class_id=Integer.valueOf(request.getParameter("class_id"));

        goodsService.insert_Service(0, goods_name, price, goods_detail,  class_id );
        return goodsService.query_ByIdService();
    }

}
