package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.services;

import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.requests.ProductRequest;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses.ProductResponse;
import in.keepgrowing.keycloakspringboot.products.domain.model.Product;
import in.keepgrowing.keycloakspringboot.products.domain.persistence.ProductRepository;

import java.util.List;
import java.util.UUID;

public class ProductHttpApiFacade {

    private final ProductRepository productRepository;

    public ProductHttpApiFacade(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> findAll() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(ProductResponse::from)
                .toList();
    }

    public ProductResponse save(ProductRequest newProduct) {
        return new ProductResponse(UUID.fromString("123e4567-e89b-42d3-a456-556642440000"),
                newProduct.name(),
                newProduct.color(),
                newProduct.ean(),
                newProduct.countryOfOrigin(),
                newProduct.price(),
                newProduct.availableQuantity());
    }
}
