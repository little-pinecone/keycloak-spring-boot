package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.services;

import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.requests.ProductRequest;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses.ProductResponse;
import in.keepgrowing.keycloakspringboot.products.domain.model.Product;
import in.keepgrowing.keycloakspringboot.products.domain.persistence.ProductRepository;

import java.util.List;

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

    public ProductResponse save(ProductRequest productRequest) {
        var product = Product.builder()
                .name(productRequest.name())
                .color(productRequest.color())
                .ean(productRequest.ean())
                .countryOfOrigin(productRequest.countryOfOrigin())
                .price(productRequest.price())
                .availableQuantity(productRequest.availableQuantity())
                .build();
        Product saved = productRepository.save(product);

        return ProductResponse.from(saved);
    }
}
