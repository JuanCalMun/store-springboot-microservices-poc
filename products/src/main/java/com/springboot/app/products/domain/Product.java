package com.springboot.app.products.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "products")
@Data
public final class Product implements Serializable {

    private static final long serialVersionUID = -8116911174777682093L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    @Temporal(TemporalType.DATE)
    private Date createAt;
}
