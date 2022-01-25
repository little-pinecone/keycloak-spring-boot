package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.services;

import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses.ProductResponse;
import in.keepgrowing.keycloakspringboot.products.domain.model.Product;
import in.keepgrowing.keycloakspringboot.products.domain.model.TestProductProvider;
import in.keepgrowing.keycloakspringboot.products.domain.persistence.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductHttpApiFacadeTest {

    private ProductHttpApiFacade apiFacade;
    private TestProductProvider productProvider;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        apiFacade = new ProductHttpApiFacade(productRepository);
        productProvider = new TestProductProvider();
    }

    @Test
    void shouldReturnAllProducts() {
        Product product = productProvider.full();
        var products = List.of(product);
        var expectedElement = ProductResponse.from(product);

        when(productRepository.findAll())
                .thenReturn(products);

        List<ProductResponse> actual = apiFacade.findAll();

        assertTrue(actual.contains(expectedElement));
    }
}