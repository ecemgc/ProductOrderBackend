package com.ecemgc.orderproductdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.EAGER)
    private List<ProductOrderEntity> productOrderEntities;
    @ManyToOne
    private UserEntity user;
}
