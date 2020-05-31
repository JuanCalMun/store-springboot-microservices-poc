package com.springboot.app.items.item.application.generator;

import com.springboot.app.items.item.domain.Item;
import com.springboot.app.items.domain.Product;

public interface ItemsGenerator {
    Item generate(final Product product, final Integer quantity);
}
