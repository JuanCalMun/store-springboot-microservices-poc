package com.springboot.app.items.item.application.provider;

import com.springboot.app.items.item.domain.ItemInfoDto;
import com.springboot.app.items.product.domain.ProductDto;
import com.springboot.app.items.product.domain.ProductClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public final class ItemProvider {

    private final ProductClient productClient;

    public ItemProvider(final ProductClient productClient) {
        this.productClient = productClient;
    }

    public List<ItemInfoDto> listAll() {
        final Integer quantity = 1;
        final List<ProductDto> allProductDtos = this.productClient.getAllProducts();
        return allProductDtos.stream().map(product ->
                new ItemInfoDto(product,
                        product.getPrice() * quantity,
                        quantity))
                .collect(Collectors.toList());
    }
}
