package com.se.mapper;
import com.se.entity.InfoDeal;
import com.se.entity.Goods;
import com.se.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;
public interface ProfileMapper {
    //查询所有交易信息
    @Select("SELECT * FROM info_deal")
    List<InfoDeal> queryDealById();

    //根据用户id查询交易信息
    @Select("SELECT * FROM info_deal WHERE sold_id = #{sold_id}")
    List<InfoDeal> queryDealBySoldId(@Param("sold_id") int sold_id);

    //根据用户account查询用户信息
    @Select("SELECT * FROM users WHERE account = #{account}")
    Users queryUserByAccount(@Param("account") String account);

    //根据用户id查询已卖出信息
    @Select("SELECT goods.* FROM info_deal, order_state ,orders, goods, users WHERE info_deal.sold_id = users.id and info_deal.order_id = order_state.order_id and orders.order_id = info_deal.order_id and orders.goods_id = goods.id and order_state.order_state = #{order_state} and users.account = #{account}")
    List<Goods> queryGoodBySoldStateId(@Param("order_state") String order_state, @Param("account") String account);

    //根据用户id查询未卖出信息
    @Select("SELECT goods.* FROM info_deal, order_state ,orders, goods, users WHERE info_deal.sold_id = users.id and info_deal.order_id = order_state.order_id and orders.order_id = order_state.order_id and orders.goods_id = goods.id and order_state.order_state = #{order_state} and users.account = #{account}")
    List<Goods> queryGoodByOnSaleStateId(@Param("order_state") String order_state, @Param("account") String account);

}
