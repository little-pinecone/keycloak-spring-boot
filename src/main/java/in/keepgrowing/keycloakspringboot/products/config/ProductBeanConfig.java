package in.keepgrowing.keycloakspringboot.products.config;

import in.keepgrowing.keycloakspringboot.products.adapters.driven.persistence.InMemoryProductRepository;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.services.ProductHttpApiFacade;
import in.keepgrowing.keycloakspringboot.products.domain.persistence.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductBeanConfig {

    @Bean
    public ProductRepository productRepository() {
        return new InMemoryProductRepository();
    }

    @Bean
    public ProductHttpApiFacade productHttpApiFacade(ProductRepository productRepository) {
        return new ProductHttpApiFacade(productRepository);
    }
}
