package com.ecemgc.orderproductdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(
		exclude = SecurityAutoConfiguration.class
)
public class OrderProductDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderProductDemoApplication.class, args);
	}

}
