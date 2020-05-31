package com.springboot.app.products.application.provider;

import com.springboot.app.products.domain.Product;
import com.springboot.app.products.domain.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class ProductsProviderImpl implements ProductsProvider {

    private final ProductRepository productRepository;

    public ProductsProviderImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> retrieveAll() {
        return (List<Product>) productRepository.findAll();
    }

}

