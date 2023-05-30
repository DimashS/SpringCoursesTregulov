package com.shynggysdimash.spring.mvc;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller // спец комонент
@RequestMapping("/emp")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails") // связка с URL => по URL вызовет метод
    public String askEmpDetails(Model model) {
//        Employee employee = new Employee();
//        employee.setName("Ivan");
//        employee.setSurname("Petrov");
//        employee.setSalary(500);
        model.addAttribute("employee", new Employee());
//        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";

    }
//
//    @RequestMapping("/")
//    public String showFirstView() {
//        return "first-view";
//    }
//
//    @RequestMapping("/askDetails") // связка с URL => по URL вызовет метод
//    public String askEmpDetails() {
//        return "ask-emp-details-view";
//    }

//        @RequestMapping("/showDetails") // связка с URL => по URL вызовет метод
//    public String showEmpDetails() {
//        return "show-emp-details-view";
//    }

    //    @RequestMapping("/showDetails") // связка с URL => по URL вызовет метод
//
//    public String showEmpDetails(HttpServletRequest request, Model model) {
//
//        String empName = request.getParameter("employeeName");
//        empName = "Mr. " + empName;
//        model.addAttribute("nameAttribute" ,empName);
//        model.addAttribute("description", " - udemy instructor");
//        return "show-emp-details-view";
//    }
//    @RequestMapping("/showDetails") // связка с URL => по URL вызовет метод
//
//    public String showEmpDetails(@RequestParam("employeeName") String empName, Model model) {
//        empName = "Mr. " + empName + "!";
//        model.addAttribute("nameAttribute", empName);
//        model.addAttribute("description", " - udemy instructor");
//        return "show-emp-details-view";

    //    @RequestMapping(path = "/showDetails", method = RequestMethod.GET) // связка с URL => по URL вызовет метод
    @PostMapping("/showDetails") // краткий вариант верхней строки => or GetMapping
    // method => если в запросе используется метод get
    // когда нажимаю окей перехожу по адресу сверху, этот переход по адресу перехватывает метод снизу
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee employee, BindingResult
            bindingResult) {
         //                               @Valid - проверка, результат валидации будет помещен в BindingResult
        System.out.println("surname length = " + employee.getSurname().length());
        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        } else {
            return "show-emp-details-view";
        }


        // ModelAttribute мы получаем доступ к аттрибуту
//        String name = employee.getName();
//        employee.setName("Mr. " + name);
//
//        String surname = employee.getSurname();
//        employee.setSurname(surname + "!!!");
//
//        int salary = employee.getSalary();
//        employee.setSalary(salary*10);
    }
}