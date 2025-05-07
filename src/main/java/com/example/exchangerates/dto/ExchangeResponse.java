package com.example.exchangerates.dto;

import lombok.Data;

@Data
public class ExchangeResponse {
    private String base_code;
    private String target_code;
    private Double conversion_rate;
}
