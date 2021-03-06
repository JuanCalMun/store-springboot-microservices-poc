package com.springboot.app.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@FeignClient
@EnableEurekaClient
public class ProductsApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ProductsApplication.class, args);
    }

}
