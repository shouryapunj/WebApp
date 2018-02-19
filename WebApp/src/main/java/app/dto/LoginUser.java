package app.dto;

import org.springframework.stereotype.Component;

@Component
public class LoginUser {

    private String loginUsername;

    public LoginUser() {

    }

    public LoginUser(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }
}
