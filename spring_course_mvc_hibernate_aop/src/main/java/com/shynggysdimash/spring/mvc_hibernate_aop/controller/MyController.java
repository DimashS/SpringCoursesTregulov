package com.shynggysdimash.spring.mvc_hibernate_aop.controller;

import com.shynggysdimash.spring.mvc_hibernate_aop.entity.Employee;
import com.shynggysdimash.spring.mvc_hibernate_aop.service.EmployeeService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmployees", allEmployees); // "allEmployees" needs in view
        return "all-employees";
    }

    @RequestMapping("/addNewEmployees")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee emp) {
        employeeService.saveEmployee(emp);
//        получаем работника из Модель Аттрибьюта, отдаем ему сервису, сервис дальше отдает вверх все
//        он в сервис, сервис в ДАО, а Дао работает с данными и save все
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee",employee);
        return "employee-info";
    }
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
