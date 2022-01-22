package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses;

import in.keepgrowing.keycloakspringboot.products.domain.model.Product;

import java.util.UUID;

public record ProductResponse(
        UUID id,
        String name,
        String color,
        String ean,
        String countryOfOrigin,
        String price,
        int availableQuantity) {

    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getColor(),
                product.getEan(),
                product.getCountryOfOrigin(),
                product.getPrice(),
                product.getAvailableQuantity()
        );
    }
}
