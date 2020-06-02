package com.springboot.app.items.product.domain;

import java.util.List;

public interface ProductClient {
    List<ProductDto> getAllProducts();

    ProductDto getOneProduct(Integer productId);
}
