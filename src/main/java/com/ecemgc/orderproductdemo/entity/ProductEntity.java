package com.ecemgc.orderproductdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String supplier;
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private List<ProductOrderEntity> productOrderEntities;

}
