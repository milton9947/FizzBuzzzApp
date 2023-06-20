package com.intraway.repository;

import com.intraway.model.FizzBuzz;
import org.springframework.data.repository.CrudRepository;

public interface FizzBuzzRepository extends CrudRepository<FizzBuzz, Long> {
}
