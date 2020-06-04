package com.springboot.app.products.infrastructure;

import com.springboot.app.products.application.finder.ProductsFinder;
import com.springboot.app.products.application.provider.ProductsProvider;
import com.springboot.app.products.domain.ProductDto;
import com.springboot.app.products.domain.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public final class ProductRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);
    private static final String LOG_INCOME_REQUEST = "Income %s request";


    private final ProductRepository productRepository;

    public ProductRestController(@Autowired final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<ProductDto> retrieveAllProducts() {
        LOGGER.info(String.format(LOG_INCOME_REQUEST, "list products"));
        final ProductsProvider productsProvider = new ProductsProvider(this.productRepository);
        return productsProvider.retrieveAll();
    }

    @GetMapping("/products/{productId}")
    public ProductDto findProduct(@PathVariable final Long productId) {
        LOGGER.info(String.format(LOG_INCOME_REQUEST, "find product"));
        final ProductsFinder productsFinder = new ProductsFinder(this.productRepository);
        return productsFinder.findById(productId);
    }
}
