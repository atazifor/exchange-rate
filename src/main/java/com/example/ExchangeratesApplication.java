package com.example;

import com.example.exchangerates.config.ExchangeRateProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ExchangeRateProperties.class)
@SpringBootApplication
public class ExchangeratesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeratesApplication.class, args);
    }

}
