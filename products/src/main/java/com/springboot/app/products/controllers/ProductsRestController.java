package com.springboot.app.products.controllers;

import com.springboot.app.products.application.finder.ProductsFinder;
import com.springboot.app.products.application.finder.ProductsFinderImpl;
import com.springboot.app.products.application.provider.ProductsProvider;
import com.springboot.app.products.application.provider.ProductsProviderImpl;
import com.springboot.app.products.domain.Product;
import com.springboot.app.products.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class ProductsRestController {

    private final ProductRepository productRepository;

    public ProductsRestController(@Autowired final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> retrieveAllProducts() {
        final ProductsProvider productsProvider = new ProductsProviderImpl(productRepository);
        return productsProvider.retrieveAll();
    }

    @GetMapping("/products/{productId}")
    public Product findProduct(@PathVariable final Long productId) {
        final ProductsFinder productsFinder = new ProductsFinderImpl(productRepository);
        return productsFinder.findById(productId);
    }
}
