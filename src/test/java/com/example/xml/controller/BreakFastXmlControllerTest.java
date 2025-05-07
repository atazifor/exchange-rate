package com.example.xml.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebFlux;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(BreakFastXmlController.class)
@AutoConfigureWebFlux
public class BreakFastXmlControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldReturnXmlMenu() {
        webTestClient.get()
                .uri("/api/menu/xml")
                .accept(MediaType.APPLICATION_XML)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_XML)
                //.expectBody()
                //.xpath("/breakfast_menu/food[1]/name[text()='Bread']").exists();
                .expectBody(String.class)
                .value(xml -> {
                    Assertions.assertTrue(xml.contains("<breakfast_menu>"));
                    Assertions.assertTrue(xml.contains("<food>"));
                });
    }

}