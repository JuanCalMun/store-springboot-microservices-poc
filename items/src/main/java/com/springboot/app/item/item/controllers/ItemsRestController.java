package com.springboot.app.item.item.controllers;

import com.springboot.app.item.item.application.generator.ItemsGenerator;
import com.springboot.app.item.item.application.provider.ItemsProvider;
import com.springboot.app.item.item.domain.Item;
import com.springboot.app.item.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
public final class ItemsRestController {

    private static final String PRODUCTS_API_URI = "http://localhost:8000";
    private static final String ALL_PRODUCTS_REQUEST = "/products";
    private static final String FIND_PRODUCT_BY_ID_REQUEST = "/products/%d";

    private final RestTemplate restTemplate;

    private final ItemsGenerator itemsGenerator;
    private final ItemsProvider itemsProvider;

    public ItemsRestController(@Autowired final ItemsGenerator itemsGenerator,
                               @Autowired final ItemsProvider itemsProvider) {
        this.itemsGenerator = itemsGenerator;
        this.itemsProvider = itemsProvider;
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        final List<Product> products = Arrays.asList(
                Objects.requireNonNull(restTemplate.getForObject(
                        PRODUCTS_API_URI + ALL_PRODUCTS_REQUEST,
                        Product[].class)));
        return itemsProvider.retrieveAllItems(products);
    }

    @GetMapping("/items/{itemId}/quantity/{itemQuantity}")
    public Item getOneItem(@PathVariable final Integer itemId, @PathVariable final Integer itemQuantity) {
        final Product product = restTemplate.getForObject(
                PRODUCTS_API_URI + String.format(FIND_PRODUCT_BY_ID_REQUEST, itemId),
                Product.class);
        return itemsGenerator.generate(product, itemQuantity);
    }

}
