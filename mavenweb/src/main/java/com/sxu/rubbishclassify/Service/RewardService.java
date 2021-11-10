package com.sxu.rubbishclassify.Service;

import com.sxu.rubbishclassify.Bean.RewardQuestion;
import com.sxu.rubbishclassify.Dao.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.beans.BeanProperty;

@Service
public class RewardService {
    @Autowired
    QuestionMapper questionMapper;
    public void insertUrl(String url){
        questionMapper.insertUrl(url);
    }
    public RewardQuestion getData(){

        return questionMapper.getUrl();//获取的是整个信息
    }
}
