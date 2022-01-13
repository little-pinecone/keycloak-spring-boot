package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses;

import in.keepgrowing.keycloakspringboot.products.domain.model.Product;
import in.keepgrowing.keycloakspringboot.products.domain.model.TestProductProvider;
import in.keepgrowing.keycloakspringboot.validation.adapters.driven.JavaxThrowingValidator;
import in.keepgrowing.keycloakspringboot.validation.domain.ports.ThrowingValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ProductResponseTest {

    private TestProductProvider productProvider;
    private ThrowingValidator validator;

    @BeforeEach
    void setUp() {
        productProvider = new TestProductProvider();
        validator = new JavaxThrowingValidator();
    }

    @Test
    void shouldCreateValidResponseFromProduct() {
        Product product = productProvider.full();

        assertDoesNotThrow(() -> ProductResponse.from(product, validator));
    }
}