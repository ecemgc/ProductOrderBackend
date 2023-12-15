package com.ecemgc.orderproductdemo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.SplittableRandom;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProduct {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String supplier;
    private int amount;
}
