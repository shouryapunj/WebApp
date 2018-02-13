package app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.ArrayList;
import java.util.HashMap;

@Configuration
@EnableWebSecurity
public class LoginConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private HashMap<String, String> profileMap;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/", "/login", "/showEmpList", "/jsonEmpList", "/thankyou", "/sendEmail", "/signup").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        for (String user : profileMap.keySet()) {
            auth.inMemoryAuthentication()
                    .withUser(user).password(profileMap.get(user)).roles("USER");
        }
    }

}