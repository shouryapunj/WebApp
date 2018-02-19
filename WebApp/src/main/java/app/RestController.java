package app;

import app.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private ArrayList<Employee> employeeArrayList;

    @RequestMapping(value = "/jsonEmpList", method = RequestMethod.GET)
    public ArrayList<Employee> jsonEmpList() {
        return employeeArrayList;
    }
}
