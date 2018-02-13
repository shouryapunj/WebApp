package app.configs;

import app.dto.Enquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class EnquiryConfig {

    @Autowired
    private ArrayList<String> emailList;

    @Autowired
    private Enquiry enquiry;

    @Bean
    public ArrayList<String> getEmailList() {
        emailList = new ArrayList<String>();
        return emailList;
    }

    @Bean
    public Enquiry getEnquiry() {
        enquiry = new Enquiry();
        return enquiry;
    }
}