package com.springboot.app.items.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Product implements Serializable {

    private static final long serialVersionUID = 6605388024083236930L;

    private Long id;
    private String name;
    private Double price;
    private Date createAt;
}
