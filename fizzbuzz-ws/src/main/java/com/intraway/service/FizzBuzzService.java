package com.intraway.service;

import com.intraway.dto.FizzBuzzDto;
import com.intraway.payload.FizzbuzzResponse;

import java.util.List;

public interface FizzBuzzService {
    List<FizzBuzzDto> findAll();
    FizzbuzzResponse fizzbuzz(Integer firstNum, Integer secNum, String path);
}
