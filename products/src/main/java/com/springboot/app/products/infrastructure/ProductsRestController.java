package com.springboot.app.products.infrastructure;

import com.springboot.app.products.application.finder.ProductsFinder;
import com.springboot.app.products.application.provider.ProductsProvider;
import com.springboot.app.products.domain.ProductDto;
import com.springboot.app.products.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class ProductsRestController {

    private final ProductRepository productRepository;
    private final Environment environment;

    public ProductsRestController(@Autowired final ProductRepository productRepository,
                                  @Autowired final Environment environment) {
        this.productRepository = productRepository;
        this.environment = environment;
    }

    @GetMapping("/products")
    public List<ProductDto> retrieveAllProducts() {
        final String serverPort = this.environment.getProperty("local.server.port");
        final ProductsProvider productsProvider = new ProductsProvider(this.productRepository);
        return productsProvider.retrieveAll(serverPort);
    }

    @GetMapping("/products/{productId}")
    public ProductDto findProduct(@PathVariable final Long productId) {
        final String serverPort = this.environment.getProperty("local.server.port");
        final ProductsFinder productsFinder = new ProductsFinder(this.productRepository);
        return productsFinder.findById(productId, serverPort);
    }
}
