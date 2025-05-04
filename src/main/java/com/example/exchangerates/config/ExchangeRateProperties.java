package com.example.exchangerates.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "exchange.api")
@Component
@Getter
@Setter
public class ExchangeRateProperties {
    private String baseUrl;
    private String key;
    private String environment;
}
