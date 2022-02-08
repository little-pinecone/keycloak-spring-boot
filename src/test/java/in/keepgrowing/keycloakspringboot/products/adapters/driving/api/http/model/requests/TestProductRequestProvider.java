package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.requests;

import dev.codesoapbox.dummy4j.Dummy4j;

public class TestProductRequestProvider {

    private final Dummy4j dummy;

    public TestProductRequestProvider() {
        dummy = new Dummy4j();
    }

    public ProductRequest full() {
        return new ProductRequest(
                dummy.lorem().word(),
                dummy.color().basicName(),
                dummy.identifier().ean13(),
                dummy.nation().country(),
                dummy.finance().priceBuilder().withCurrency("EUR").build(),
                dummy.number().nextInt(1, 100)
        );
    }
}
