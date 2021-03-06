package app.controllers;

import app.dto.Employee;
import app.dto.Enquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;


@Controller
public class EmployeeController {

    @Autowired
    private Employee employee;

    @Autowired
    private ArrayList<Employee> employeeArrayList;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("enquiry", new Enquiry());
        return "login";
    }

    @GetMapping("/employee")
    public String employeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee";
    }

    @PostMapping("/employee")
    public String employeeSubmit(@ModelAttribute Employee employee, @Valid Employee employeeCheck, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee";
        }
        this.employee = employee;
        employeeArrayList.add(employee);
        return "result";
    }


    @RequestMapping(value = "/showEmpList", method = RequestMethod.GET)
    public String showEmpList(Model model) {
        model.addAttribute("empList", employeeArrayList);
        return "showEmpList";
    }

    @RequestMapping(value = "/jsonEmpList", method = RequestMethod.GET)
    public ArrayList<Employee> jsonEmpList() {
        return employeeArrayList;
    }
}