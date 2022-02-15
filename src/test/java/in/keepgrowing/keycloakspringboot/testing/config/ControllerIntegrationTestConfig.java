package in.keepgrowing.keycloakspringboot.testing.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@TestConfiguration
@EnableMethodSecurity
public class ControllerIntegrationTestConfig {
}
