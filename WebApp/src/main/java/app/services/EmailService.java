package app.services;

import app.dto.Email;
import app.dto.Enquiry;
import app.dto.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
@PropertySource("classpath:properties/application.properties")
public class EmailService implements ApplicationRunner {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private EmailService emailService;

    @Autowired
    private Enquiry enquiry;

    @Autowired
    private Profile profile;

    @Autowired
    private Email email;

    public void sendSimpleEmail(final Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(email.getSubject());
        message.setFrom(email.getFrom());
        message.setTo(email.getTo());
        message.setText(email.getContent());
        emailSender.send(message);
    }

    public void sendEmailUsingWebAppEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(email.getSubject());
        message.setFrom(email.getFrom());
        message.setTo(email.getTo());
        message.setText(email.getContent());
        emailSender.send(message);
    }

    public String sendProfileCredentials() {
        Email email = new Email();
        email.setFrom("admin");
        email.setTo(profile.getEmail());
        email.setSubject("Login Credentials | GG");
        String passcode = generateRandomPassword();
        email.setContent("Hey " + profile.getName() + "," + '\n' + '\n' + "Your profile has been created. Login credentials → " + '\n' + '\n' + "Username → " + profile.getUsername() + '\n' + '\n' + "Password → "  + passcode
                + '\n' + '\n' + "Thanks," + '\n' + '\n' + "GG");
        emailService.sendSimpleEmail(email);
        return passcode;
    }

    public void run() throws Exception {
        String toEmailAddress = enquiry.getEmail();
        Email email = new Email();
        email.setFrom("xyz@gmail.com");
//        email.setTo("mithul.nayagam@reflexisinc.com");
        email.setTo(toEmailAddress);
        email.setSubject("Support Team @ GG");
        email.setContent("Hey," + '\n' + '\n' + "Thank you for using GG. It seems that you are new at GG and need some help. You can reply back on this thread for any query that you have, we will be more than happy to help you!"
                + '\n' + '\n' + "Thanks," + '\n' + '\n' + "GG");
        emailService.sendSimpleEmail(email);
    }

    public String generateRandomPassword() {
        Random random = new SecureRandom();
        String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";
        String pw = "";
        for (int i = 0; i < 8; i++) {
            int index = (int) (random.nextDouble() * letters.length());
            pw += letters.substring(index, index + 1);
        }
        return pw;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
    }

}