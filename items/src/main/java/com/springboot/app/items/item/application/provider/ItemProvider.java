package com.springboot.app.items.item.application.provider;

import com.springboot.app.items.item.domain.Item;
import com.springboot.app.items.product.domain.Product;
import com.springboot.app.items.product.domain.ProductClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public final class ItemProvider {

    private ProductClient productClient;

    public ItemProvider(ProductClient productClient) {
        this.productClient = productClient;
    }

    public List<Item> listAll() {
        final Integer quantity = 1;
        List<Product> allProducts = productClient.getAllProducts();
        return allProducts.stream().map(product -> new Item(product, quantity)).collect(Collectors.toList());
    }
}
