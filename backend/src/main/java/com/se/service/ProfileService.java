package com.se.service;
import com.se.entity.Goods;
import com.se.entity.InfoDeal;
import com.se.entity.Users;
import com.se.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private ProfileMapper profileMapper;

    //查询所有商品信息
    public List<InfoDeal> queryByIdService() {
        return profileMapper.queryDealById();
    }

    //根据用户id查询交易信息
    public List<InfoDeal> queryBySoldIdService(int sold_id) {
        return profileMapper.queryDealBySoldId(sold_id);
    }

    //根据id查询用户信息
    public Users queryByUserIdService(String account) {
        return profileMapper.queryUserByAccount(account);
    }

    //根据用户id查询已卖出信息
    public List<Goods> queryBySoldStateService(String order_state, String account) {
        return profileMapper.queryGoodBySoldStateId(order_state,account);
    }

    //根据用户id查询未卖出信息
    public List<Goods> queryByOnSaleStateService(String order_state,String account) {
        return profileMapper.queryGoodByOnSaleStateId(order_state,account);
    }

}
