package com.intraway.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FizzbuzzResponse {
    private Long timestamp;
    private String code;
    private String description;
    private String list;
}
