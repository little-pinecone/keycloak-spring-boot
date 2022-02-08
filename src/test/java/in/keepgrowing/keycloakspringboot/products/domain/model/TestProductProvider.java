package in.keepgrowing.keycloakspringboot.products.domain.model;

import dev.codesoapbox.dummy4j.Dummy4j;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.requests.ProductRequest;

public class TestProductProvider {

    private final Dummy4j dummy;

    public TestProductProvider() {
        this.dummy = new Dummy4j();
    }

    public Product withoutId() {
        return Product.builder()
                .name(dummy.lorem().word() + " " + dummy.lorem().word())
                .color(dummy.color().name())
                .ean(dummy.identifier().ean13())
                .countryOfOrigin(dummy.nation().country())
                .price(dummy.finance().priceBuilder().withCurrency("USD").build())
                .availableQuantity(dummy.number().nextInt(1, 200))
                .build();
    }

    public Product full() {
        var product = withoutId();
        product.setId(dummy.identifier().uuid());

        return product;
    }
    
    public Product fromRequest(ProductRequest request) {
        return Product.builder()
                .name(request.name())
                .color(request.color())
                .ean(request.ean())
                .countryOfOrigin(request.countryOfOrigin())
                .price(request.price())
                .availableQuantity(request.availableQuantity())
                .build();
    }
}
