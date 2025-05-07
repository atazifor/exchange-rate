package com.example.xml.controller.dto;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlRootElement(name = "breakfast_menu")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class BreakfastMenu {
    @XmlElement(name = "food")
    private List<Food> foods;
}

