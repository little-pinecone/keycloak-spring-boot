package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.services;

import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses.ProductResponse;
import in.keepgrowing.keycloakspringboot.products.domain.model.Product;
import in.keepgrowing.keycloakspringboot.products.domain.model.TestProductProvider;
import in.keepgrowing.keycloakspringboot.products.domain.ports.persistence.ProductRepository;
import in.keepgrowing.keycloakspringboot.validation.adapters.driven.JavaxThrowingValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductHttpApiFacadeTest {

    private ProductHttpApiFacade apiFacade;
    private TestProductProvider productProvider;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productProvider = new TestProductProvider();
        apiFacade = new ProductHttpApiFacade(productRepository, new JavaxThrowingValidator());
    }

    @Test
    void shouldFindAllProducts() {
        Product product = productProvider.full();
        var products = List.of(product);

        when(productRepository.findAll())
                .thenReturn(products);

        List<ProductResponse> actual = apiFacade.findAll();

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertNotNull(actual.get(0));
    }
}