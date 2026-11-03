package Proxy;

import java.util.Objects;

public final class User {
    private final String username;

    public User(String username) {
        Objects.requireNonNull(username, "username");
        if (username.isBlank()) {
            throw new IllegalArgumentException("username must not be blank");
        }
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
