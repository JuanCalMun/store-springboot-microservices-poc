package com.springboot.app.items.item.domain;

import com.springboot.app.items.product.domain.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public final class ItemInfoDto implements Serializable {

    private static final long serialVersionUID = 7332739266866283251L;

    private ProductDto productDto;
    private Double totalPrice;
    private Integer quantity;
}
