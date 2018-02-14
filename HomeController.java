package app.controllers;

import app.dto.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private LoginUser loginUser;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHome() {

        return "home";
    }
}
