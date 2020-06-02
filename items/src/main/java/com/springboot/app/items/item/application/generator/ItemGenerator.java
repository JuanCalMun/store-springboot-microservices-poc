package com.springboot.app.items.item.application.generator;

import com.springboot.app.items.item.domain.ItemInfoDto;
import com.springboot.app.items.product.domain.ProductDto;
import com.springboot.app.items.product.domain.ProductClient;
import org.springframework.stereotype.Service;

@Service
public final class ItemGenerator {

    private final ProductClient productClient;

    public ItemGenerator(final ProductClient productClient) {
        this.productClient = productClient;
    }

    public ItemInfoDto generate(final Integer itemId, final Integer quantity) {
        final ProductDto productDto = this.productClient.getOneProduct(itemId);
        final Double totalPrice = productDto.getPrice() * quantity;
        return new ItemInfoDto(productDto, totalPrice, quantity);
    }
}
