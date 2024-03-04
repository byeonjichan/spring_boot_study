package com.study.mvc.controller;

import com.study.mvc.model.HelloModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;



@Controller
public class StudyController {

    //MVC
    @GetMapping("/hello")
    public String helloPage(Model model) {
        HelloModel helloModel = HelloModel.builder()
                .name1("변지찬1")
                .name2("변지찬2")
                .name3("변지찬3")
                .build();
        model.addAttribute("h" , helloModel);
        return "hello";
    }

    // REST
    @ResponseBody
    @GetMapping("/test")
    public Map<String, Object> testPage(Model model) {
        model.addAttribute("age",32);
        Map<String, Object> testObj = new HashMap<>();
        testObj.put("age", 32);
        return testObj;
    }
}
