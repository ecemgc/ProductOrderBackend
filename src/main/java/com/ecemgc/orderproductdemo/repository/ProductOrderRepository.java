package com.ecemgc.orderproductdemo.repository;

import com.ecemgc.orderproductdemo.entity.ProductOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrderEntity, Long> {
}
