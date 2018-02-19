package app.dto;

import org.springframework.stereotype.Component;

@Component
public class Profile {

    private String name;

    private String email;

    private String username;

    public Profile() {

    }

    public Profile(String name, String email, String username) {
        this.name = name;
        this.email = email;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public static interface NameStep {
        EmailStep withName(String name);
    }

    public static interface EmailStep {
        UsernameStep withEmail(String email);
    }

    public static interface UsernameStep {
        BuildStep withUsername(String username);
    }

    public static interface BuildStep {
        Profile build();
    }

    public static class Builder implements NameStep, EmailStep, UsernameStep, BuildStep {
        private String name;
        private String email;
        private String username;

        private Builder() {
        }

        public static NameStep profile() {
            return new Builder();
        }

        @Override
        public EmailStep withName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public UsernameStep withEmail(String email) {
            this.email = email;
            return this;
        }

        @Override
        public BuildStep withUsername(String username) {
            this.username = username;
            return this;
        }

        @Override
        public Profile build() {
            return new Profile(
                    this.name,
                    this.email,
                    this.username
            );
        }
    }
}