package com.springboot.app.items.product.infrastructure.client;

import com.springboot.app.items.product.domain.ProductDto;
import com.springboot.app.items.product.domain.ProductClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public final class ProductRestClient implements ProductClient {
    private static final String PRODUCTS_API_URI = "http://localhost:8000";
    private static final String ALL_PRODUCTS_REQUEST = "/products";
    private static final String FIND_PRODUCT_BY_ID_REQUEST = "/products/%d";

    private final RestTemplate restTemplate;

    public ProductRestClient() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return Arrays.asList(
                Objects.requireNonNull(this.restTemplate.getForObject(
                        PRODUCTS_API_URI + ALL_PRODUCTS_REQUEST,
                        ProductDto[].class)));
    }

    @Override
    public ProductDto getOneProduct(final Integer productId) {
        return this.restTemplate.getForObject(
                PRODUCTS_API_URI + String.format(FIND_PRODUCT_BY_ID_REQUEST, productId),
                ProductDto.class);
    }

}
