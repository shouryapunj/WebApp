package app.controllers;

import app.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
    public String sendEmail() throws Exception {
        emailService.run();
        return "email";
    }

}