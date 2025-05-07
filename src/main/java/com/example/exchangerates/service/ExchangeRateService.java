package com.example.exchangerates.service;

import com.example.exchangerates.config.ExchangeRateProperties;
import com.example.exchangerates.dto.ExchangeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ExchangeRateService {
    private final ExchangeRateProperties exchangeRateProperties;
    private final WebClient webClient;

    public ExchangeRateService(ExchangeRateProperties exchangeRateProperties, WebClient.Builder builder) {
        this.exchangeRateProperties = exchangeRateProperties;
        this.webClient = builder.baseUrl(exchangeRateProperties.getBaseUrl()).build();
        System.out.println("exchangeRateProperties.getEnvironment() = " + exchangeRateProperties.getEnvironment());
    }

    public Mono<ResponseEntity<String>> getRates(String baseCurrency) {
        String url = String.format("%s/%s/latest/%s", exchangeRateProperties.getBaseUrl(), exchangeRateProperties.getKey(), baseCurrency);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .map(body -> ResponseEntity.ok(body))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    public Mono<Double> getRate(String fromCurrency, String toCurrency) {
        String path = String.format("/%s/pair/%s/%s", exchangeRateProperties.getKey(), fromCurrency, toCurrency);
        return webClient.get()
                .uri(path)
                .retrieve()
                .bodyToMono(ExchangeResponse.class)
                .map(response -> response.getConversion_rate());
    }
}
