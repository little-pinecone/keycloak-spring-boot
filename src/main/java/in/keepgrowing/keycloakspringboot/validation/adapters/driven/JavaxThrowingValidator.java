package in.keepgrowing.keycloakspringboot.validation.adapters.driven;

import in.keepgrowing.keycloakspringboot.validation.domain.ports.ThrowingValidator;

import javax.validation.*;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public class JavaxThrowingValidator implements ThrowingValidator {

    private final Validator validator;

    public JavaxThrowingValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Override
    public void validate(Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            String message = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(joining(System.lineSeparator()));
            throw new ConstraintViolationException(message, violations);
        }
    }
}
