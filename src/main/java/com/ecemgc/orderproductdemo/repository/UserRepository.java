package com.ecemgc.orderproductdemo.repository;

import com.ecemgc.orderproductdemo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    //@Query("SELECT U FROM UserEntity U WHERE  U.email = ?1")
    Optional<UserEntity> findByEmail(String email);
}
