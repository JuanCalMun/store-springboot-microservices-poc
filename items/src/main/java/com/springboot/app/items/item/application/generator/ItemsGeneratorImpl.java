package com.springboot.app.items.item.application.generator;

import com.springboot.app.items.item.domain.Item;
import com.springboot.app.items.domain.Product;
import org.springframework.stereotype.Service;

@Service
public final class ItemsGeneratorImpl implements ItemsGenerator {

    @Override
    public Item generate(final Product product, final Integer quantity) {
        return new Item(product,quantity);
    }
}
