package com.shynggysdimash.spring.rest.controller;

import com.shynggysdimash.spring.rest.entity.Employee;
import com.shynggysdimash.spring.rest.exception_handling.EmployeeIncorrectData;
import com.shynggysdimash.spring.rest.exception_handling.NoSuchEmployeeException;
import com.shynggysdimash.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }

    // id - pathVariable. Айди в адресе
    @RequestMapping("employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("there is no employee with ID = " + id + " in Database");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

                                                                          // через requestBody => конвертация json в java объект
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee); // this is not id, therefore we will get updated member of employee
        return employee; // convertation in JSON and will be added to HTTP response body
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmp(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no id employee with such ID " + id + " in database" );
        }
        employeeService.deleteEmployee(id);
        return "Employee with id: " + id + " was deleted";
    }
}
