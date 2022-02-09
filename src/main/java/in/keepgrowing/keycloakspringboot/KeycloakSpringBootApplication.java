package in.keepgrowing.keycloakspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class KeycloakSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeycloakSpringBootApplication.class, args);
	}

}
