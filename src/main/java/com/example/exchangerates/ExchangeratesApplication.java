package com.example.exchangerates;

import com.example.exchangerates.config.ExchangeRateProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableConfigurationProperties(ExchangeRateProperties.class)
@SpringBootApplication
public class ExchangeratesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeratesApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
