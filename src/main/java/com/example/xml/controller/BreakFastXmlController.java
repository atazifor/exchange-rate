package com.example.xml.controller;

import com.example.xml.controller.dto.BreakfastMenu;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

@RestController
@RequestMapping("/api/menu")
public class BreakFastXmlController {

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public BreakfastMenu getXmlMenu() throws Exception {
        URL url = new URL("https://www.w3schools.com/xml/simple.xml");
        JAXBContext context = JAXBContext.newInstance(BreakfastMenu.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (BreakfastMenu) unmarshaller.unmarshal(url);
    }
}
