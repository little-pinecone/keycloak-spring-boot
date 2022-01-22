package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses;

import dev.codesoapbox.dummy4j.Dummy4j;

public class TestProductResponseProvider {

    private final Dummy4j dummy;

    public TestProductResponseProvider() {
        dummy = new Dummy4j();
    }

    public ProductResponse full() {
        return new ProductResponse(
                dummy.identifier().uuid(),
                dummy.lorem().word(),
                dummy.color().basicName(),
                dummy.identifier().ean13(),
                dummy.nation().country(),
                dummy.finance().priceBuilder().withCurrency("EUR").build(),
                dummy.number().nextInt(1, 100)
        );
    }
}
