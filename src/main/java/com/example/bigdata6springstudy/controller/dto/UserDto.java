package com.example.bigdata6springstudy.controller.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UserDto {
    private int userNo;
    private String name;
    private  int sal;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
}
