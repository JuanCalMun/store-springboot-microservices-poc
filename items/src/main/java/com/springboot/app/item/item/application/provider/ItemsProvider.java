package com.springboot.app.item.item.application.provider;

import com.springboot.app.item.item.domain.Item;
import com.springboot.app.item.product.domain.Product;

import java.util.List;

public interface ItemsProvider {
    List<Item> retrieveAllItems(List<Product> productList);
}
