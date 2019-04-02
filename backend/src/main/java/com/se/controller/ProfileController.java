package com.se.controller;

import com.se.entity.InfoDeal;
import com.se.entity.Users;
import com.se.entity.Goods;
import com.se.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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

    //根据卖家id查询交易信息
    @RequestMapping("/queryDealBySoldId")
    public List<InfoDeal> dealQueryBySoldId() {
        return profileService.queryBySoldIdService(1);
    }
    //根据id查询用户信息
    @RequestMapping("/queryUserById")
    public Users userQueryById() {
        return profileService.queryByUserIdService("cyy");
    }

    //根据用户id查询已卖出信息
    @RequestMapping("/queryGoodBySoldId")
    public List<Goods> goodQueryBySoldId() {
        return profileService.queryBySoldStateService("sold","cyy");
    }

    //根据用户id查询未卖出信息
    @RequestMapping("/queryGoodByOnSaleId")
    public List<Goods> goodQueryByOnSaleId() {
        return profileService.queryByOnSaleStateService("onsale","cyy");
    }
}
