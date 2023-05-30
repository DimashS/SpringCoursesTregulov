package com.shynggysdimash.spring.rest;

import com.shynggysdimash.spring.rest.configuration.MyConfig;
import com.shynggysdimash.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
//        List<Employee> allEmployees = communication.getAllEmployees();
//        System.out.println(allEmployees);

//        Employee employeeID = communication.getEmp(1);
//        System.out.println(employeeID);

//        Employee employee = new Employee("Sveta","Skolova","IT",1200);
//        update one of (department)
//        employee.setId(7); // чтобы были внесены изменения, а не INSERT NEW EMPLOYEE
//        communication.saveEmployee(employee);

        communication.deleteEmployee(7);

    }
}
