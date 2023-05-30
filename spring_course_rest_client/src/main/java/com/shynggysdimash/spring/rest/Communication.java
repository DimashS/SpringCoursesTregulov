package com.shynggysdimash.spring.rest;

import com.shynggysdimash.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

// с его помощью (объектов, методов) будем общаться с Rest сервисом, т.е. осуществлять http запросы и получать ответы
@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/spring_course_rest/api/employees";

    public List<Employee> getAllEmployees() {
        // ответ на наш HTTP запрос
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Employee>>() {
                        }); // это вспом.класс, цель которого передача
        // Generic типа, то есть список работника у нас


        // get payload (полезная нагрузка)
        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }

    public Employee getEmp(int id) {
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class); // второй параметр, что ожидаем получить
        return employee;
    }

    public void saveEmployee(Employee employee) {
        int id = employee.getId();
        if (id == 0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New employee was added to DB");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with ID " + id + " was updated");
        }

    }
    // так мы записываем именно те методы где requestMapping идёт api/employees/{id} ИМЕННО С ID
    public void deleteEmployee(int id) {
        restTemplate.delete(URL + "/" +id);
        System.out.println("Employee with ID: " + id + " was deleted from database");
    }
}
