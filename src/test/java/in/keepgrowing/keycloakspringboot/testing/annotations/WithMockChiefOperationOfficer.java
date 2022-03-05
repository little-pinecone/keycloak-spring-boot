package in.keepgrowing.keycloakspringboot.testing.annotations;

import org.springframework.security.test.context.support.WithMockUser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(roles = "CHIEF-OPERATING-OFFICER")
public @interface WithMockChiefOperationOfficer {
}
