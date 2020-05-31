package com.springboot.app.items.product.domain;

import java.util.List;

public interface ProductsRequestClient {
    List<Product> getAllProducts();

    Product getProductBy(Integer productId);
}
