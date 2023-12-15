package com.ecemgc.orderproductdemo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestProduct {
    private String name;
    private String description;
    private BigDecimal price;
    private String supplier;
    private int amount;
}
