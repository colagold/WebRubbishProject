package com.sxu.rubbishclassify.Controller;

import com.sxu.rubbishclassify.Bean.News;
import com.sxu.rubbishclassify.Dao.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping()
public class NewsController {
    @Autowired
    private NewsMapper newsMapper;
    @GetMapping("/getNews")
    public List<News> getNews(){
        List<News> newsList=newsMapper.getNews();
        System.out.println(newsList.get(1).getNew_content());
        return newsList;
    }
}
