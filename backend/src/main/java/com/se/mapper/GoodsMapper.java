package com.se.mapper;

import com.se.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodsMapper {

    //查询所有商品信息
    @Select("SELECT * FROM goods")
    List<Goods> queryGoodsById();

    //根据名字查询商品信息
    @Select("SELECT * FROM goods WHERE title = #{title}")
    List<Goods> queryGoodsByTitle(@Param("title") String title);

    //插入商品信息
    @Insert("INSERT INTO goods(id, title, star, name, city, hot) VALUES(#{id}, #{title}, #{star}, #{name}, #{city}, #{hot})")
    void insertGoods(@Param("id") int id, @Param("title") String title, @Param("star") int star, @Param("name") String name, @Param("city") String city, @Param("hot") int hot);

    //根据id修改商品信息
    @Update("Update goods set title = #{title}, star = #{star}, name = #{name}, city = #{city}, hot = #{hot} WHERE id = #{id}")
    void updateGoods(@Param("id") int id, @Param("title") String title, @Param("star") int star, @Param("name") String name, @Param("city") String city, @Param("hot") int hot);

    //根据id删除商品信息
    @Delete("DELETE from goods WHERE id = #{id}")
    void deleteGoods(@Param("id") int id);
}
