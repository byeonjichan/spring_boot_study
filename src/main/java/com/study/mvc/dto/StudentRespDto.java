package com.study.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentRespDto {
    private String name;
    private int age;
    private String phone;
    private String address;

    public StudentRespDto toRespDto() {
        return StudentRespDto.builder()
                .name(name)
                .age(age)
                .phone(phone)
                .address(address)
                .build();
    }
}

