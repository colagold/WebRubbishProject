package com.sxu.rubbishclassify.Dao;

import com.sxu.rubbishclassify.Bean.Garbage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface SearchMapper {
    List<Garbage> findRubbish(String name);
}
