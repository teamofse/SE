package com.se.mapper;

import com.se.entity.Goods;
import com.se.entity.GoodsInformation;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodsMapper {

    //发布时插入商品信息
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    @Insert("INSERT INTO goods_information(goods_id,goods_name,price,goods_detail,class_id) VALUES(#{goods_id}, #{goods_name}, #{price}, #{goods_detail}, #{class_id})")
    void insertGoodsInformation(@Param("goods_id") int goods_id,@Param("goods_name") String goods_name, @Param("price") int price, @Param("goods_detail") String goods_detail, @Param("class_id") int class_id);
=======
    @Insert("INSERT INTO goods_information(goods_id,goods_name,price,goods_detail,class_id，goods_picture_4) VALUES(#{goods_id}, #{goods_name}, #{price}, #{goods_detail}, #{class_id},#{goods_picture_4})")
    void insertGoodsInformation(@Param("goods_id") int goods_id,@Param("goods_name") String goods_name, @Param("price") int price, @Param("goods_detail") String goods_detail, @Param("class_id") int class_id, @Param("goods_picture_4") String goods_picture_4);
>>>>>>> parent of 3ceed98... 给陈煜元看！
=======
    @Insert("INSERT INTO goods_information(goods_id,goods_name,price,goods_detail,class_id，goods_picture_4) VALUES(#{goods_id}, #{goods_name}, #{price}, #{goods_detail}, #{class_id},#{goods_picture_4})")
    void insertGoodsInformation(@Param("goods_id") int goods_id,@Param("goods_name") String goods_name, @Param("price") int price, @Param("goods_detail") String goods_detail, @Param("class_id") int class_id, @Param("goods_picture_4") String goods_picture_4);
>>>>>>> parent of 3ceed98... 给陈煜元看！
=======
    @Insert("INSERT INTO goods_information(goods_id,goods_name,price,goods_detail,class_id，goods_picture_4) VALUES(#{goods_id}, #{goods_name}, #{price}, #{goods_detail}, #{class_id},#{goods_picture_4})")
    void insertGoodsInformation(@Param("goods_id") int goods_id,@Param("goods_name") String goods_name, @Param("price") int price, @Param("goods_detail") String goods_detail, @Param("class_id") int class_id, @Param("goods_picture_4") String goods_picture_4);
>>>>>>> parent of 3ceed98... 给陈煜元看！

    //插入商品信息
    @Insert("INSERT INTO goods(id, title, star, name, city, hot) VALUES(#{id}, #{title}, #{star}, #{name}, #{city}, #{hot})")
    void insertGoods(@Param("id") int id, @Param("title") String title, @Param("star") int star, @Param("name") String name, @Param("city") String city, @Param("hot") int hot);

    //查询所有商品信息
    @Select("SELECT * FROM goods")
    List<Goods> queryGoodsById();

    //查询所有商品信息
    @Select("SELECT * FROM goods_information")
    List<GoodsInformation> queryGoodsInformationById();

    //根据名字查询商品信息
    @Select("SELECT * FROM goods WHERE title = #{title}")
    List<Goods> queryGoodsByTitle(@Param("title") String title);

    //根据id修改商品信息
    @Update("Update goods set title = #{title}, star = #{star}, name = #{name}, city = #{city}, hot = #{hot} WHERE id = #{id}")
    void updateGoods(@Param("id") int id, @Param("title") String title, @Param("star") int star, @Param("name") String name, @Param("city") String city, @Param("hot") int hot);

    //根据id删除商品信息
    @Delete("DELETE from goods WHERE id = #{id}")
    void deleteGoods(@Param("id") int id);

    //根据id查询商品信息
    @Select("SELECT * FROM goods WHERE id = #{id}")
    Goods selectGoodsById(@Param("id") int id);
}
