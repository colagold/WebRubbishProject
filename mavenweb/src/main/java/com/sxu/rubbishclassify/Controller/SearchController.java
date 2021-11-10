package com.sxu.rubbishclassify.Controller;

import com.sxu.rubbishclassify.Bean.Garbage;
import com.sxu.rubbishclassify.Dao.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchMapper searchMapper;
    @GetMapping("/getinfo")
    public List<Garbage> getGarbage(HttpServletRequest request){
        String name=request.getParameter("name");
        List<Garbage> garbage=searchMapper.findRubbish(name);
        return  garbage;
    }

}
