package com.intraway.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FizzBuzz {
    @Id
    @GeneratedValue
    private Long id;
    private Integer firstNum;
    private Integer secNum;
    private String result;
    @CreationTimestamp
    private Timestamp createDate;
}
