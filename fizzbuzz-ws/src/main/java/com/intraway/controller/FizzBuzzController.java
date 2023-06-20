package com.intraway.controller;

import com.intraway.dto.FizzBuzzDto;
import com.intraway.payload.FizzbuzzResponse;
import com.intraway.service.FizzBuzzService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intraway/api/fizzbuzz")
@CrossOrigin
@Tag(name = "FizzBuzz")
public class FizzBuzzController {
    private  final FizzBuzzService fizzBuzzService;

    @Autowired
    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping
    public ResponseEntity<List<FizzBuzzDto>> findAll(){
        return new ResponseEntity<>(fizzBuzzService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/{firstNum}/{secNum}")
    public ResponseEntity<FizzbuzzResponse> deposit(
            @PathVariable @Min(Integer.MIN_VALUE) @Max(Integer.MAX_VALUE) Integer firstNum,
            @PathVariable @Min(Integer.MIN_VALUE) @Max(Integer.MAX_VALUE) Integer secNum,
            HttpServletRequest request){
        return new ResponseEntity<>(fizzBuzzService
                .fizzbuzz(firstNum, secNum, request.getRequestURI()), HttpStatus.OK);
    }
}
