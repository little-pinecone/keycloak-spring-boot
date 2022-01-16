package in.keepgrowing.keycloakspringboot.validation.adapters.driving.api.http;

import in.keepgrowing.keycloakspringboot.validation.domain.ports.ThrowingValidator;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Objects;

@Aspect
@Slf4j
public class ControllerResponseValidator {

    private final ThrowingValidator validator;

    public ControllerResponseValidator(ThrowingValidator validator) {
        this.validator = validator;
    }

    // Todo: fix validating collection (should work by defalult)
    @AfterReturning(
            pointcut = "@within(org.springframework.web.bind.annotation.RestController))",
            returning = "response")
    public void validateResponseBody(JoinPoint joinPoint, ResponseEntity<?> response) {
        if (response.getBody() instanceof Collection<?> res) {
            log.info("Validating response collection");
            Objects.requireNonNull(res)
                    .forEach(validator::validate);
        } else {
            log.info("Validating response body");
            validator.validate(response.getBody());
        }
    }
}
