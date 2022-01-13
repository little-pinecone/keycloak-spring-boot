package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses;

import in.keepgrowing.keycloakspringboot.products.domain.model.Product;
import in.keepgrowing.keycloakspringboot.validation.domain.ports.ThrowingValidator;
import lombok.AccessLevel;
import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record ProductResponse(

        @NotNull
        UUID id,

        String name,
        String color,

        @NotBlank
        String ean,

        String countryOfOrigin,
        String price,
        int availableQuantity) {

    @Builder(access = AccessLevel.PRIVATE)
    public ProductResponse {
    }

    public static ProductResponse from(Product product, ThrowingValidator validator) {
        var response = ProductResponse.builder()
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
