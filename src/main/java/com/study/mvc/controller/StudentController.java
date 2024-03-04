package com.study.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.mvc.dto.StudentReqDto;
import com.study.mvc.entity.Student;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@CookieValue String students, @RequestBody Student student) throws JsonProcessingException {
        List<Student> studentList = new ArrayList<>();
        int lastId = 0;

        if (students != null) {
            ObjectMapper studentCookie = new ObjectMapper();
            studentList = studentCookie.readValue(students, List.class);
            studentList.get(studentList.size()-1).getStudentId();
        }

        student.setStudentId(lastId + 1);
        studentList.add(student);

        ObjectMapper newStudentList = new ObjectMapper();
        String newStudents = newStudentList.writeValueAsString(studentList);
        ResponseCookie responseCookie = ResponseCookie.from("test" , "test_data")
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(60)
                .build();
        return ResponseEntity.created(null).body(student);
    }

    @GetMapping("/student")
    public ResponseEntity<?> getStudentInfo(StudentReqDto studentReqDto) {
        System.out.println(studentReqDto);

        return ResponseEntity.badRequest().body(studentReqDto.toRespDto());
    }
    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable int studentId) {
        List<Student> studentList = List.of(
                new Student(1, "변지찬"),
                new Student(2, "번지찬"),
                new Student(3, "변재찬"),
                new Student(4, "변찬찬")
        );
        Student findStudent = null;
        for (Student student : studentList) {
            if(student.getStudentId() == studentId) {
                findStudent = student;
            }
        }
        if (findStudent == null){
            return ResponseEntity.badRequest().body(Map.of("errorMessage", "존재하지 않는 ID 입니다"));
        }

        return ResponseEntity.ok().body(findStudent);
    }
}
