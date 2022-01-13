package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses;

import in.keepgrowing.keycloakspringboot.products.domain.model.Product;
import in.keepgrowing.keycloakspringboot.validation.domain.ports.ThrowingValidator;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@EqualsAndHashCode
@Builder(access = AccessLevel.PRIVATE)
@ToString
public class ProductResponseSecond {

    @NotNull
    private UUID id;

    private String name;
    private String color;

    @NotBlank
    private String ean;

    private String countryOfOrigin;
    private String price;
    private int availableQuantity;

    public static ProductResponseSecond from(Product product, ThrowingValidator validator) {
        var response = ProductResponseSecond.builder()
                .id(product.getId())
                .name(product.getName())
                .color(product.getColor())
                .ean(product.getEan())
                .countryOfOrigin(product.getCountryOfOrigin())
                .price(product.getPrice())
                .availableQuantity(product.getAvailableQuantity())
                .build();

        validator.validate(response);

        return response;
    }
}
