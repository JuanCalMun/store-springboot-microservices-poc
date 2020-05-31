package com.springboot.app.item.item.domain;

import com.springboot.app.item.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class Item {
    private Product product;
    private Integer quantity;
}
