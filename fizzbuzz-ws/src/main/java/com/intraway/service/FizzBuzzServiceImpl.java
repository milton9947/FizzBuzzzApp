package com.intraway.service;

import com.intraway.dto.FizzBuzzDto;
import com.intraway.exception.types.BadRequest;
import com.intraway.model.FizzBuzz;
import com.intraway.payload.FizzbuzzResponse;
import com.intraway.repository.FizzBuzzRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    private final FizzBuzzRepository fizzBuzzRepository;
    private final Mapper mapper;

    @Autowired
    public FizzBuzzServiceImpl(FizzBuzzRepository fizzBuzzRepository, Mapper mapper) {
        this.fizzBuzzRepository = fizzBuzzRepository;
        this.mapper = mapper;
    }

    @Override
    public List<FizzBuzzDto> findAll() {
        List<FizzBuzzDto> fizzBuzzDtos = new ArrayList<>();
        fizzBuzzRepository.findAll()
                .forEach(i->fizzBuzzDtos.add(mapper.map(i, FizzBuzzDto.class)));

        return fizzBuzzDtos;
    }

    @Override
    public FizzbuzzResponse fizzbuzz(Integer firstNum, Integer secNum, String path) {
        if ( firstNum > secNum ) {
            throw new BadRequest("Bad Request", "Los parámetros enviados son incorrectos", path);
        }

        String response = IntStream.rangeClosed(firstNum, secNum)
                .mapToObj(this::mapIntToFizzBuzz)
                .collect(Collectors.joining(","));

        fizzBuzzRepository.save(FizzBuzz.builder()
                .firstNum(firstNum)
                .secNum(secNum)
                .result(response).build());

        return buildFizzbuzzResponse(response);
    }

    private FizzbuzzResponse buildFizzbuzzResponse(String response){
        String code = null;
        String description = null;

        if( response.contains("Fizz") && response.contains("Buzz") ) {
            code = "001";
            description = "se encontraron multiplos de 3 y de 5";
        } else if( response.contains("Fizz") && !response.contains("Buzz") ) {
            code = "002";
            description = "se encontraron multiplos de 3";
        }  else if( !response.contains("Fizz") && response.contains("Buzz") ) {
            code = "003";
            description = "se encontraron multiplos de 5";
        } else {
            code = "004";
            description = "No se encontraron multiplos";
        }

        return FizzbuzzResponse.builder()
                .timestamp(System.currentTimeMillis())
                .code(code)
                .description(description)
                .list(response)
                .build();
    }

    private String mapIntToFizzBuzz(int i) {
        if(i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        } else if(i % 3 == 0) {
            return "Fizz";
        }else if(i % 5 == 0) {
            return "Buzz";
        }

        return Integer.toString(i);
    }
}
