package com.se.controller;

import com.se.entity.Goods;
import com.se.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController

public class HomeController {
    @Autowired
    private GoodsService goodsService;

    //查询所有商品信息
    @RequestMapping("/queryGoodsById")
    public List<Goods> goodsQueryById(){
        return goodsService.queryByIdService();
    }

    //根据名字查询商品信息
    @RequestMapping("/queryGoodsByTitle")
    public List<Goods> goodsQueryByTitle() {
        return goodsService.queryByTitleService("朱一龙");
    }

    //插入商品信息
    @RequestMapping("/insertGoods")
    public List<Goods> goodsInsert(){
        goodsService.insertService(3, "朱一龙", 300, "bbb", "ccc");
        return goodsService.queryByIdService();
    }

    //根据id修改商品信息
    @RequestMapping("/updateGoods")
    public List<Goods> goodsUpdate() {
        goodsService.updateService(3, "ddd", 400, "eee", "fff");
        return goodsService.queryByIdService();
    }

    //根据id删除商品信息
    @RequestMapping("/deleteGoods")
    public String goodsDelete() {
        goodsService.deleteService(3);
        return "OK";
    }

}
