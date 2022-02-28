package in.keepgrowing.keycloakspringboot.shared.config;

import in.keepgrowing.keycloakspringboot.KeycloakSpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.function.Predicate;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public static final String API_PREFIX = "api";

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(API_PREFIX, createPredicateForControllers());
    }

    private Predicate<Class<?>> createPredicateForControllers() {
        String packageName = KeycloakSpringBootApplication.class.getPackageName();

        return HandlerTypePredicate
                .forBasePackage(packageName)
                .and(HandlerTypePredicate.forAnnotation(RestController.class));
    }
}
