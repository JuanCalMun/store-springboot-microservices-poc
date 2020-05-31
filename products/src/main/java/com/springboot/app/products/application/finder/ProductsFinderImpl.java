package com.springboot.app.products.application.finder;

import com.springboot.app.products.domain.Product;
import com.springboot.app.products.domain.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public final class ProductsFinderImpl implements ProductsFinder {

    private final ProductRepository productRepository;

    public ProductsFinderImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(final Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
}
