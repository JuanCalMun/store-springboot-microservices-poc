package com.springboot.app.items.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class ProductDto implements Serializable {

    private static final long serialVersionUID = -43371186381320426L;
    private String name;
    private Double price;
    private Date createAt;
    private String serverPort;
}
