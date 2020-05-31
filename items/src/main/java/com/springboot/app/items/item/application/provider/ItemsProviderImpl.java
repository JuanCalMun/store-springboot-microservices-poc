package com.springboot.app.items.item.application.provider;

import com.springboot.app.items.item.domain.Item;
import com.springboot.app.items.product.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public final class ItemsProviderImpl implements ItemsProvider {

    @Override
    public List<Item> retrieveAllItems(final List<Product> productList) {
        final Integer quantity = 1;
        return productList.stream().map(product -> new Item(product, quantity)).collect(Collectors.toList());
    }
}
