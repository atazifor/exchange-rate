package com.example.exchangerates.controller;

import com.example.exchangerates.service.ExchangeRateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;


@WebFluxTest(ExchangeRateController.class)
class ExchangeRateControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockitoBean
    private ExchangeRateService service;

    @Test
    void shouldReturnRawExchangeRateResponse() {
        String mockApiResponse = """
        {
            "base_code": "USD",
            "conversion_rates": {
                "EUR": 0.92,
                "XAF": 610.00
            }
        }
        """;
        Mockito.when(service.getRates("USD")).thenReturn(Mono.just(ResponseEntity.ok(mockApiResponse)));
        webTestClient.get()
                .uri("/api/exchange/USD")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(body -> {
                    Assertions.assertTrue(body.contains("\"base_code\": \"USD\""));
                    Assertions.assertTrue(body.contains("\"XAF\": 610.00"));
                });
    }

    @Test
    void shouldReturnConversion() {
        Mockito.when(service.getRate("USD", "EUR")).thenReturn(Mono.just(0.92));
        webTestClient.get()
                .uri("/api/exchange/convert?from=USD&to=EUR")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(body -> Assertions.assertTrue(body.contains("1 USD = 0.92 EUR")));
    }
}