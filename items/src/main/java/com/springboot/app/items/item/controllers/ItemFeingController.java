package com.springboot.app.items.item.controllers;

import com.springboot.app.items.item.application.generator.ItemsGenerator;
import com.springboot.app.items.item.application.provider.ItemsProvider;
import com.springboot.app.items.item.domain.Item;
import com.springboot.app.items.product.controllers.ProductsFeingClient;
import com.springboot.app.items.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feing")
public final class ItemFeingController {

    private final ItemsGenerator itemsGenerator;
    private final ItemsProvider itemsProvider;
    private final ProductsFeingClient productsClient;

    public ItemFeingController(@Autowired ItemsGenerator itemsGenerator,
                               @Autowired ItemsProvider itemsProvider,
                               @Autowired ProductsFeingClient productsClient) {
        this.itemsGenerator = itemsGenerator;
        this.itemsProvider = itemsProvider;
        this.productsClient = productsClient;
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        final List<Product> products = productsClient.getAllProducts();
        return itemsProvider.retrieveAllItems(products);
    }

    @GetMapping("/items/{itemId}/quantity/{itemQuantity}")
    public Item getOneItem(@PathVariable final Integer itemId, @PathVariable final Integer itemQuantity) {
        final Product product = productsClient.getProductBy(itemId);
        return itemsGenerator.generate(product, itemQuantity);
    }
}
