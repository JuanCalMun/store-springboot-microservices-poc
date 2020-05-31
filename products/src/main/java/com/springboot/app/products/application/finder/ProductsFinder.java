package com.springboot.app.products.application.finder;

import com.springboot.app.products.domain.Product;

public interface ProductsFinder {
    Product findById(Long productId);
}
