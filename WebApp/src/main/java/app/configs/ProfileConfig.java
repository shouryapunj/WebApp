package app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ProfileConfig {

    @Autowired
    private static HashMap<String, String> profileMap;

    @Bean
    public static HashMap<String, String> getProfileMap() {
        profileMap = new HashMap<String, String>();
        profileMap.put("admin", "admin");
        return profileMap;
    }
}