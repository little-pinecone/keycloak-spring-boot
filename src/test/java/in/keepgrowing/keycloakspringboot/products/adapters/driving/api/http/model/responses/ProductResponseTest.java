package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses;

import in.keepgrowing.keycloakspringboot.products.domain.model.Product;
import in.keepgrowing.keycloakspringboot.products.domain.model.TestProductProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductResponseTest {

    private TestProductProvider productProvider;

    @BeforeEach
    void setUp() {
        productProvider = new TestProductProvider();
    }

    @Test
    void shouldCreateProductResponseWithoutNullFields() {
        Product product = productProvider.full();
        ProductResponse response = ProductResponse.from(product);

        assertThat(response).hasNoNullFieldsOrProperties();
    }
}