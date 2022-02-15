package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.services;

import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.requests.ProductRequest;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.requests.TestProductRequestProvider;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses.ProductResponse;
import in.keepgrowing.keycloakspringboot.products.domain.model.Product;
import in.keepgrowing.keycloakspringboot.products.domain.model.TestProductProvider;
import in.keepgrowing.keycloakspringboot.products.domain.persistence.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductHttpApiFacadeTest {

    private TestProductProvider productProvider;
    private TestProductRequestProvider productRequestProvider;

    @InjectMocks
    private ProductHttpApiFacade apiFacade;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productProvider = new TestProductProvider();
        productRequestProvider = new TestProductRequestProvider();
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

    @Test
    void shouldSaveAndReturnNewProduct() {
        ProductRequest request = productRequestProvider.full();
        Product product = productProvider.fromRequest(request);
        ProductResponse expected = ProductResponse.from(product);

        when(productRepository.save(product))
                .thenReturn(product);

        ProductResponse actual = apiFacade.save(request);

        assertEquals(expected, actual);
    }

    @Test
    void shouldDeleteProductById() {
        var id = UUID.fromString("11111111-1111-1111-1111-111111111111");
        apiFacade.deleteById(id);

        verify(productRepository).deleteById(id);
    }
}