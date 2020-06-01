package com.springboot.app.items.item.controllers;

import com.springboot.app.items.item.application.generator.ItemGenerator;
import com.springboot.app.items.item.application.provider.ItemProvider;
import com.springboot.app.items.item.domain.Item;
import com.springboot.app.items.product.domain.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public final class ItemRestController {

    private final ItemGenerator itemGenerator;
    private final ItemProvider itemProvider;

    public ItemRestController(@Autowired ProductClient productClient) {
        this.itemGenerator = new ItemGenerator(productClient);
        this.itemProvider = new ItemProvider(productClient);
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemProvider.listAll();
    }

    @GetMapping("/items/{itemId}/quantity/{itemQuantity}")
    public Item getOneItem(@PathVariable final Integer itemId, @PathVariable final Integer itemQuantity) {
        return itemGenerator.generate(itemId, itemQuantity);
    }

}
