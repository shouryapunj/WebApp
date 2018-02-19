package app.configs;

import app.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class EmployeeConfig {

    @Autowired
    private ArrayList<Employee> employeeArrayList;

    @Bean
    public Employee getEmployee() {
        return new Employee();
    }

    @Bean
    public ArrayList<Employee> getEmployeeList() {
        employeeArrayList = new ArrayList<Employee>();
        return employeeArrayList;
    }
}