package app.controllers;

import app.dto.Enquiry;
import app.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class EnquiryController {

    @Autowired
    private Enquiry enquiry;

    @Autowired
    private ArrayList<String> emailList;

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/thankyou", method = RequestMethod.GET)
    public String thankYouGet(Model model) {
        model.addAttribute("enquiry", new Enquiry());
        return "thankyou";
    }

    @RequestMapping(value = "/thankyou", method = RequestMethod.POST)
    public String thankYouPost(@ModelAttribute Enquiry enq, @Valid Enquiry enquiryCheck, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        enquiry.setEmail(enq.getEmail());
        emailList.add(this.enquiry.getEmail());
        try {
            emailService.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thankyou";
    }
}