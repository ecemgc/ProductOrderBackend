package com.ecemgc.orderproductdemo.repository;

import com.ecemgc.orderproductdemo.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
