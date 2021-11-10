package com.sxu.rubbishclassify.Dao;

import com.sxu.rubbishclassify.Bean.Question;
import com.sxu.rubbishclassify.Bean.Rank;
import com.sxu.rubbishclassify.Bean.RewardQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionMapper {
    List<Question> getQuestion();
    List<Rank> getRank();
    RewardQuestion getUrl();
    boolean insertUrl(@Param("url")String url);
    void updateData(@Param("RewardQuestion") RewardQuestion rewardQuestion);
}
