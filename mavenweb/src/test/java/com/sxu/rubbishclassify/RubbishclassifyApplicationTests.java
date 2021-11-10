package com.sxu.rubbishclassify;

import com.sxu.rubbishclassify.Dao.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RubbishclassifyApplicationTests {

    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private WasteMapper wasteMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Test
    void contextLoads() {
        System.out.println("新闻标题:"+newsMapper.getNews().get(0).getNew_title());
        System.out.println("用户信息"+userMapper.selectUser("4").getAccount());
        System.out.println(wasteMapper.insertWaste(4,"2020-12-15-18:00","54寸电视","不能开机"));
        System.out.println(wasteMapper.insertWaste(5,"2020-12-16-18:00","海尔洗衣间","已不能使用"));
//        System.out.println(userMapper.updateScore("5",50));
//        System.out.println(goodsMapper.insertGood(4,"联想笔记本",1999,"购于京东","无"));
//        System.out.println(goodsMapper.insertGood(4,"牛津字典",66,"购于京东","无"));
//        System.out.println(goodsMapper.insertGood(5,"iPad 2020",2399,"购于京东","无"));
//        System.out.println(goodsMapper.insertGood(6,"小米手环4",99,"购于京东","无"));
//        System.out.println(userMapper.insertUser("13093564588","zxcvbnm","安徽省合肥市"));
//        System.out.println(newsMapper.updateLook(2,10));
        System.out.println(questionMapper.insertUrl("www.baidu.com"));
    }

}
