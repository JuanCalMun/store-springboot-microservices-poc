package com.springboot.app.products.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class ProductDto implements Serializable {
    private static final long serialVersionUID = 8361138333439885164L;

    private String name;
    private Double price;
    private Date createAt;
    private String serverPort;
}
