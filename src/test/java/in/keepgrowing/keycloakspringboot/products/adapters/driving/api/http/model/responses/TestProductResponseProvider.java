package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses;

import in.keepgrowing.keycloakspringboot.products.domain.model.TestProductProvider;
import in.keepgrowing.keycloakspringboot.validation.adapters.driven.JavaxThrowingValidator;
import in.keepgrowing.keycloakspringboot.validation.domain.ports.ThrowingValidator;

public class TestProductResponseProvider {

    private final TestProductProvider productProvider;
    private final ThrowingValidator validator;

    public TestProductResponseProvider() {
        productProvider = new TestProductProvider();
        validator = new JavaxThrowingValidator();
    }

    public ProductResponse fromRandomProduct() {
        return ProductResponse.from(productProvider.full(), validator);
    }
}
