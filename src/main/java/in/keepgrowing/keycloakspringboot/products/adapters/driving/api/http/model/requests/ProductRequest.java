package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.requests;

public record ProductRequest(
        String name,
        String color,
        String ean,
        String countryOfOrigin,
        String price,
        int availableQuantity) {
}
