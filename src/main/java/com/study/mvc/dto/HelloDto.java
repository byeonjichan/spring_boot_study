package com.study.mvc.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HelloDto {
    private String name;
    private int age;
}
