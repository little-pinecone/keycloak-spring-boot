package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.services;

import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses.ProductResponse;
import in.keepgrowing.keycloakspringboot.products.domain.model.Product;
import in.keepgrowing.keycloakspringboot.products.domain.ports.persistence.ProductRepository;
import in.keepgrowing.keycloakspringboot.validation.domain.ports.ThrowingValidator;

import java.util.List;

public class ProductHttpApiFacade {

    private final ProductRepository productRepository;
    private final ThrowingValidator validator;

    public ProductHttpApiFacade(ProductRepository productRepository, ThrowingValidator validator) {
        this.productRepository = productRepository;
        this.validator = validator;
    }

    public List<ProductResponse> findAll() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map((Product product) -> ProductResponse.from(product, validator))
                .toList();
    }
}
