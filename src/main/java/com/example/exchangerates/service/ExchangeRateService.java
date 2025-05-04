package com.example.exchangerates.service;

import com.example.exchangerates.config.ExchangeRateProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeRateService {
    private final ExchangeRateProperties exchangeRateProperties;
    private final RestTemplate restTemplate;

    public ExchangeRateService(ExchangeRateProperties exchangeRateProperties, RestTemplate restTemplate) {
        this.exchangeRateProperties = exchangeRateProperties;
        this.restTemplate = restTemplate;
        System.out.println("exchangeRateProperties.getEnvironment() = " + exchangeRateProperties.getEnvironment());
    }

    public ResponseEntity<String> getRates(String baseCurrency) {
        String url = String.format("%s/%s/latest/%s", exchangeRateProperties.getBaseUrl(), exchangeRateProperties.getKey(), baseCurrency);
        return restTemplate.getForEntity(url, String.class);
    }
}
