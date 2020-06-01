package com.springboot.app.items.product.domain;

import java.util.List;

public interface ProductClient {
    List<Product> getAllProducts();

    Product getOneProduct(Integer productId);
}
