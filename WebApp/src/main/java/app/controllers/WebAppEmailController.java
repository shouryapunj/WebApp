package app.controllers;

import app.dto.Email;
import app.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class WebAppEmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private Email email;

    @RequestMapping(value = "/webAppEmail", method = RequestMethod.GET)
    public String webAppEmail(Model model) {
        model.addAttribute("email", new Email());
        return "webAppEmail";
    }

    @RequestMapping(value = "/webAppEmail", method = RequestMethod.POST)
    public String webAppEmail(@ModelAttribute Email emailAttribute, @Valid Email emailCheck, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "webAppEmail";
        }
        //TODO: call email service
        email.setFrom(emailAttribute.getFrom());
        email.setTo(emailAttribute.getTo());
        email.setSubject(emailAttribute.getSubject());
        email.setContent(emailAttribute.getContent());
        emailService.sendEmailUsingWebAppEmail();
        return "emailSent";
    }
}
