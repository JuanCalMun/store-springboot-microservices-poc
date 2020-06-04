package com.springboot.app.products.application.provider;

import com.springboot.app.products.domain.Product;
import com.springboot.app.products.domain.ProductDto;
import com.springboot.app.products.domain.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public final class ProductsProvider {

    private final ProductRepository productRepository;

    public ProductsProvider(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> retrieveAll() {
        final List<Product> products = (List<Product>) this.productRepository.findAll();
        return products.stream().map(product -> new ProductDto(product.getName(), product.getPrice(),
                product.getCreateAt())).collect(Collectors.toList());
    }

}

