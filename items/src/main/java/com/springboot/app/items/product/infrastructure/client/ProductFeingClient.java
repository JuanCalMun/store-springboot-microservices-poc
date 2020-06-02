package com.springboot.app.items.product.infrastructure.client;

import com.springboot.app.items.product.domain.ProductDto;
import com.springboot.app.items.product.domain.ProductClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Primary
@FeignClient(name = "products-service")
public interface ProductFeingClient extends ProductClient {
        @Override
        @GetMapping("/products")
        List<ProductDto> getAllProducts();

        @Override
        @GetMapping("/products/{productId}")
        ProductDto getOneProduct(@PathVariable Integer productId);
}
