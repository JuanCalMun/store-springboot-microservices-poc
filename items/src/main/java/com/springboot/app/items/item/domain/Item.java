package com.springboot.app.items.item.domain;

import com.springboot.app.items.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class Item {
    private Product product;
    private Integer quantity;
}
