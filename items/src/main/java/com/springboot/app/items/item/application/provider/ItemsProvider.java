package com.springboot.app.items.item.application.provider;

import com.springboot.app.items.item.domain.Item;
import com.springboot.app.items.product.domain.Product;

import java.util.List;

public interface ItemsProvider {
    List<Item> retrieveAllItems(List<Product> productList);
}
