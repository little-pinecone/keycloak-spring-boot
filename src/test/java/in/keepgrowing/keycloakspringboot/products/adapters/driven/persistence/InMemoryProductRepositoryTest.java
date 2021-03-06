package in.keepgrowing.keycloakspringboot.products.adapters.driven.persistence;

import in.keepgrowing.keycloakspringboot.products.domain.model.Product;
import in.keepgrowing.keycloakspringboot.products.domain.model.TestProductProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryProductRepositoryTest {

    private InMemoryProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new InMemoryProductRepository();
    }

    @Test
    void shouldReturnListOfProducts() {
        List<Product> actual = productRepository.findAll();

        assertNotNull(actual);
        assertEquals(InMemoryProductRepository.INITIAL_AMOUNT, actual.size());
        assertNotNull(actual.get(0));
    }

    @Test
    void shouldReturnProductById() {
        UUID id = getProductIdBasedOnExistingOne();

        Optional<Product> actual = productRepository.findById(id);

        assertTrue(actual.isPresent());
    }

    private UUID getProductIdBasedOnExistingOne() {
        List<Product> products = productRepository.findAll();

        return UUID.fromString(products.get(0).getId().toString());
    }

    @Test
    void shouldReturnEmptyOptionalForNotExistingProduct() {
        var invalidId = UUID.fromString("11111111-1111-1111-1111-111111111111");

        Optional<Product> actual = productRepository.findById(invalidId);

        assertTrue(actual.isEmpty());
    }

    @Test
    void shouldSaveAndReturnProduct() {
        var productProvider = new TestProductProvider();
        Product product = productProvider.withoutId();

        Product actual = productRepository.save(product);

        assertEquals(InMemoryProductRepository.INITIAL_AMOUNT + 1, productRepository.findAll().size());
        assertNotNull(actual.getId());
    }

    @Test
    void shouldDeleteProductById() {
        UUID id = getProductIdBasedOnExistingOne();

        productRepository.deleteById(id);

        Optional<Product> nonExisting = productRepository.findById(id);

        assertTrue(nonExisting.isEmpty());
    }

    @Test
    void shouldTryToDeleteNonExistingProductById() {
        var id = UUID.fromString("11111111-1111-1111-1111-111111111111");

        productRepository.deleteById(id);

        Optional<Product> nonExisting = productRepository.findById(id);

        assertTrue(nonExisting.isEmpty());
    }
}