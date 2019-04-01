package com.se.service;


import com.se.entity.Goods;
import com.se.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    //查询所有商品信息
    public List<Goods> queryByIdService() {
        return goodsMapper.queryGoodsById();
    }

    //根据名字查询商品信息
    public List<Goods> queryByTitleService(String title) {
        return goodsMapper.queryGoodsByTitle(title);
    }

    //插入商品信息
    public void insertService(int id, String title, int star, String name, String city, int hot) {
        goodsMapper.insertGoods(id, title, star, name, city, hot);
    }

    //根据id修改商品信息
    public void updateService(int id, String title, int star, String name, String city, int hot) {
        goodsMapper.updateGoods(id, title, star, name, city, hot);
    }

    //根据id删除商品信息
    public void deleteService(int id) {
        goodsMapper.deleteGoods(id);
    }
}
