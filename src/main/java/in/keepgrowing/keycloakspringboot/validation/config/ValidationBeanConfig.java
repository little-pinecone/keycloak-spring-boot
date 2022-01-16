package in.keepgrowing.keycloakspringboot.validation.config;

import in.keepgrowing.keycloakspringboot.validation.adapters.driven.JavaxThrowingValidator;
import in.keepgrowing.keycloakspringboot.validation.adapters.driving.api.http.ControllerResponseValidator;
import in.keepgrowing.keycloakspringboot.validation.domain.ports.ThrowingValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationBeanConfig {

    @Bean
    public ThrowingValidator throwingValidator() {
        return new JavaxThrowingValidator();
    }

    @Bean
    public ControllerResponseValidator controllerResponseValidator(ThrowingValidator validator) {
        return new ControllerResponseValidator(validator);
    }
}
