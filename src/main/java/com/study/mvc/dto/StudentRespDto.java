package com.study.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class StudentRespDto {
    private String name;
    private int age;
    private String phone;
    private String address;
}

