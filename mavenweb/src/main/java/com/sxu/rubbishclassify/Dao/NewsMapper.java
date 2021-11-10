package com.sxu.rubbishclassify.Dao;

import com.sxu.rubbishclassify.Bean.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface NewsMapper {
    List<News> getNews();
    int deleteNews(@Param("newsId")int newsId);
    int insertNews(@Param("news")News news);
    int updateLook(@Param("newsId")int newsId,@Param("look")int look);
    int updateGood(@Param("newsId")int newsId,@Param("good")int good);
}
