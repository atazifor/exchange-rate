package com.example.exchangerates.controller;


import com.example.exchangerates.service.ExchangeRateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/{baseCurrency}")
    public Mono<ResponseEntity<String>> getRates(@PathVariable String baseCurrency) {
        return exchangeRateService.getRates(baseCurrency);
    }

    @GetMapping("/convert")
    public Mono<ResponseEntity<String>> getRate(@RequestParam String from, @RequestParam String to) {
        return exchangeRateService.getRate(from, to)
                .map(rate -> ResponseEntity.ok(String.format("1 %s = %.2f %s", from, rate, to)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
