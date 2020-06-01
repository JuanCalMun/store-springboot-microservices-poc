package com.springboot.app.items.product.controllers.client;

import com.springboot.app.items.product.domain.Product;
import com.springboot.app.items.product.domain.ProductClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Primary
@FeignClient(name = "products-services", url="localhost:8000")
public interface ProductFeingClient extends ProductClient {
        @GetMapping("/products")
        List<Product> getAllProducts();

        @GetMapping("/products/{productId}")
        Product getOneProduct(@PathVariable Integer productId);
}
