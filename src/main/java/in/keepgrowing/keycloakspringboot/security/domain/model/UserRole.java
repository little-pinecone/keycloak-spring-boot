package in.keepgrowing.keycloakspringboot.security.domain.model;

public enum UserRole {

    CHIEF_OPERATING_OFFICER("CHIEF-OPERATING-OFFICER"),
    USER("USER");

    final String value;

    UserRole(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
