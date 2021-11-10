package com.sxu.rubbishclassify.Dao;

import com.sxu.rubbishclassify.Bean.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface GoodsMapper {
    int insertGoods(@Param("goods")Goods goods);
    int insertGood(@Param("userId")int userId,@Param("goodsName")String goodsName,@Param("goodsPrice")int goodsPrice,@Param("goodsInfo")String goodsInfo,@Param("goodsUrl")String goodsUrl);
    int deleteGoods(@Param("goodsId") int goodsId);
    int updateGoodsPrice(@Param("goodsId")int goodsId,@Param("goodsPrice")int goodsPrice);
    List<Goods> selectGoods();
    List<Goods> selectGoodsByPrice(@Param("minPrice")int minPrice,@Param("maxPrice")int maxPrice);
}
