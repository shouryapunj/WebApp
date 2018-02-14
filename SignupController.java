package app.controllers;

import app.configs.LoginConfig;
import app.dto.Profile;
import app.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
public class SignupController  {

    @Autowired
    private Profile profile;

    @Autowired
    private HashMap<String, String> profileMap;

    @Autowired
    private EmailService emailService;

    @Autowired
    private LoginConfig loginConfig;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUp(Model model) {
        model.addAttribute("profile", new Profile());
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String singUp(@ModelAttribute Profile p, @Valid Profile pCheck, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        profile.setName(p.getName());
        profile.setEmail(p.getEmail());
        profile.setUsername(p.getUsername());
        String pw = emailService.sendProfileCredentials();
        profileMap.put(profile.getUsername(), pw);
        //TODO: Add logic to update profiles in login config
        return "profileCreated";
    }
}