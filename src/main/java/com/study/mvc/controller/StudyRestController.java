package com.study.mvc.controller;

import com.study.mvc.dto.HelloDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/* Controller명: StudentController
   메소드명 : getStudentInfo()
   요청메소드 : GET
   요청 URL : /student
   요청 Params : name, age , phone , address
   응답데이터 JSON(name, age , phone , address)
* */

@RestController // <- 전부 responsebody화 해서 데이터로 받는다
public class StudyRestController {

    @GetMapping("/hello/test")
    public String hello(HelloDto helloDto) { //자동을 형변환 시켜줘서 parseint() 안해도 됨

        System.out.println(helloDto);


        return "Hello";
    }


}
