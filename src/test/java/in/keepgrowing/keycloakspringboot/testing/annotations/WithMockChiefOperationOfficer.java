package in.keepgrowing.keycloakspringboot.testing.annotations;

import org.springframework.security.test.context.support.WithMockUser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(roles="CHIEF-OPERATING-OFFICER")
public @interface WithMockChiefOperationOfficer {
}
