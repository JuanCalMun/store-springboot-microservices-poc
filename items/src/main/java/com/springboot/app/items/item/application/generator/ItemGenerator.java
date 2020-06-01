package com.springboot.app.items.item.application.generator;

import com.springboot.app.items.item.domain.Item;
import com.springboot.app.items.product.domain.Product;
import com.springboot.app.items.product.domain.ProductClient;
import org.springframework.stereotype.Service;

@Service
public final class ItemGenerator {

    ProductClient productClient;

    public ItemGenerator(ProductClient productClient) {
        this.productClient = productClient;
    }

    public Item generate(final Integer itemId, final Integer quantity) {
        Product product = productClient.getOneProduct(itemId);
        return new Item(product,quantity);
    }
}
