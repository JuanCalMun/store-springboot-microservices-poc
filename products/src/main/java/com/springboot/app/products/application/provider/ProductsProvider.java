package com.springboot.app.products.application.provider;

import com.springboot.app.products.domain.Product;

import java.util.List;

public interface ProductsProvider {
    List<Product> retrieveAll();
}
