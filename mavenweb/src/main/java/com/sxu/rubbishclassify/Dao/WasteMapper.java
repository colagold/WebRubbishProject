package com.sxu.rubbishclassify.Dao;

import com.sxu.rubbishclassify.Bean.Waste;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface WasteMapper {
    int insertWastes(@Param("waste")Waste waste);
    int deleteWaste(@Param("wasteId")int wasteId);
    int insertWaste(@Param("userId")int userId,@Param("wasteTime")String wasteTime,@Param("wasteName")String wasteName,@Param("wasteInfo")String wasteInfo);
    List<Waste> selectWaste();
//    List<Waste> selectWasteByTime();
}
