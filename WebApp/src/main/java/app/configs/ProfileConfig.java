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
        profileMap.put("Super-Admin", "cnvbcnvb");
        profileMap.put("admin", "adminXY");
        profileMap.put("shourya", "1");
        profileMap.put("swarn", "swarn");
        profileMap.put("mithul","mithul");
        profileMap.put("rohan","rohan");
        profileMap.put("anshu","anshu");
        profileMap.put("arnav","arnav");
        profileMap.put("vyom","vyom");
        profileMap.put("sreekar", "sreekar");
        profileMap.put("vishal", "vishal");
        profileMap.put("barkha", "barkha");
        profileMap.put("saharsha", "saharsha");
        profileMap.put("shivraj", "shivraj");
        profileMap.put("naveen","naveen");
        profileMap.put("sachin","sachin");
        profileMap.put("vidya","vidya");
        profileMap.put("guest","guest");
        return profileMap;
    }
}