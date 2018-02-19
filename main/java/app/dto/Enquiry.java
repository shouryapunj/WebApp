package app.dto;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class Enquiry {

    @NotNull
    private String email;

    public Enquiry() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}