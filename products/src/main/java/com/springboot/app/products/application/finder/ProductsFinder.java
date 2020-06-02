package com.springboot.app.products.application.finder;

import com.springboot.app.products.domain.Product;
import com.springboot.app.products.domain.ProductDto;
import com.springboot.app.products.domain.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public final class ProductsFinder {
    private final ProductRepository productRepository;

    public ProductsFinder(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDto findById(final Long productId, final String localServerPort) {
        final Product product = this.productRepository.findById(productId).orElse(null);

        return product!=null ?
                new ProductDto(product.getName(), product.getPrice(), product.getCreateAt(),
                localServerPort):
                new ProductDto();
    }
}
