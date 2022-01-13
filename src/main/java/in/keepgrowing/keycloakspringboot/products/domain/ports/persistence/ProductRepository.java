package in.keepgrowing.keycloakspringboot.products.domain.ports.persistence;

import in.keepgrowing.keycloakspringboot.products.domain.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    List<Product> findAll();

    Optional<Product> findById(UUID productId);

    Optional<Product> save(Product productDetails);
}
