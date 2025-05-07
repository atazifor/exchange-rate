package com.example.xml.controller.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Food {
    private String name;
    private String description;
    private String price;
    private String calories;
}
