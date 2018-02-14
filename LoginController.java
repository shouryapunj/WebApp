package app.controllers;

import app.dto.Enquiry;
import app.dto.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    private LoginUser loginUser;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("enquiry", new Enquiry());
        model.addAttribute("user", new LoginUser());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginForm(@ModelAttribute LoginUser user, @ModelAttribute Enquiry enquiry) {
        loginUser.setLoginUsername(user.getLoginUsername());
        return "home";
    }
}
