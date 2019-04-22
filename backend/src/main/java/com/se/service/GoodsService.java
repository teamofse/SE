package com.se.service;


import com.se.entity.Goods;
import com.se.entity.GoodsInformation;
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

    //查询所有商品信息
    public List<GoodsInformation> query_ByIdService() {
        return goodsMapper.queryGoodsInformationById();
    }

    //根据名字查询商品信息
    public List<Goods> queryByTitleService(String title) {
        return goodsMapper.queryGoodsByTitle(title);
    }

    //发布时插入商品信息
    public void insert_Service(int goods_id,String goods_name,int price,String goods_detail,int class_id)
    {
        goodsMapper.insertGoodsInformation(goods_id, goods_name, price, goods_detail, class_id);
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

    //根据id查找商品信息
    public Goods selectGoodsByItemId(int id) {
        return goodsMapper.selectGoodsById(id);
    }
}
