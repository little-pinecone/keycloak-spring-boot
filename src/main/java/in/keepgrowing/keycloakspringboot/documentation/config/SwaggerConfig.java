package in.keepgrowing.keycloakspringboot.documentation.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
@AllArgsConstructor
public class SwaggerConfig {

    @Bean
    OpenAPI customOpenApi(SwaggerProperties swaggerProperties) {
        return new OpenAPI()
                .info(getInfo(swaggerProperties));
    }

    public Info getInfo(SwaggerProperties swaggerProperties) {
        return new Info()
                .title(swaggerProperties.projectTitle())
                .description(swaggerProperties.projectDescription())
                .version(swaggerProperties.projectVersion())
                .license(getLicense());
    }

    private License getLicense() {
        return new License()
                .name("Unlicense")
                .url("https://unlicense.org/");
    }
}
