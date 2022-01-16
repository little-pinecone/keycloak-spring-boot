package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses;

import in.keepgrowing.keycloakspringboot.products.domain.model.Product;
import in.keepgrowing.keycloakspringboot.validation.domain.ports.ThrowingValidator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record ProductResponse(

        @NotNull
        UUID id,

        @NotBlank
        String name,

        @NotBlank
        String color,

        @NotBlank
        String ean,

        @NotBlank
        String countryOfOrigin,

        @NotBlank
        String price,

        @Min(0)
        int availableQuantity) {

    public static ProductResponse from(Product product, ThrowingValidator validator) {
        var response = new ProductResponse(
                product.getId(),
                product.getName(),
                product.getColor(),
                product.getEan(),
                product.getCountryOfOrigin(),
                product.getPrice(),
                product.getAvailableQuantity()
        );
        validator.validate(response);

        return response;
    }
}
