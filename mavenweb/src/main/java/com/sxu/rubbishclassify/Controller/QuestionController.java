package com.sxu.rubbishclassify.Controller;

import com.sxu.rubbishclassify.Bean.Question;
import com.sxu.rubbishclassify.Bean.RewardQuestion;
import com.sxu.rubbishclassify.Dao.QuestionMapper;
import com.sxu.rubbishclassify.Service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class QuestionController {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private RewardService rewardService;
    @GetMapping("/getquestion")
    public List<Question> getQuestion(){
        List<Question> listQuestion=questionMapper.getQuestion();
        return listQuestion;
    }
    @GetMapping("/getUrl")
    public RewardQuestion getReward(){
        return rewardService.getData();
    }
    @GetMapping("/insertUrl")
    public String insertUrl(@RequestParam("url")String url){
        if (questionMapper.insertUrl(url)) {
            return "200";
        }
        return "404";
    }
}
