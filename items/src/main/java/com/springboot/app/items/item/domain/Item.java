package com.springboot.app.items.item.domain;

import com.springboot.app.items.product.domain.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class Item {
    private ProductDto productDto;
    private Integer quantity;
}
