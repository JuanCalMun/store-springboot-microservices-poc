package com.springboot.app.item.item.application.generator;

import com.springboot.app.item.item.domain.Item;
import com.springboot.app.item.product.domain.Product;
import org.springframework.stereotype.Service;

@Service
public final class ItemsGeneratorImpl implements ItemsGenerator {

    @Override
    public Item generate(final Product product, final Integer quantity) {
        return new Item(product,quantity);
    }
}
