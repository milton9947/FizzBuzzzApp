package com.intraway.dto;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class FizzBuzzDto {
    private Integer firstNum;
    private Integer secNum;
    private String result;
    private Timestamp createDate;
}
