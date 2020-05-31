package com.springboot.app.item.item.application.generator;

import com.springboot.app.item.item.domain.Item;
import com.springboot.app.item.product.domain.Product;

public interface ItemsGenerator {
    Item generate(final Product product, final Integer quantity);
}
