package com.springboot.app.items.product.controllers;

import com.springboot.app.items.product.domain.Product;
import com.springboot.app.items.product.domain.ProductsRequestClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "products-services", url="localhost:8000")
public interface ProductsFeingClient extends ProductsRequestClient {
        @GetMapping("/products")
        List<Product> getAllProducts();

        @GetMapping("/products/{productId}")
        Product getProductBy(@PathVariable Integer productId);
}
