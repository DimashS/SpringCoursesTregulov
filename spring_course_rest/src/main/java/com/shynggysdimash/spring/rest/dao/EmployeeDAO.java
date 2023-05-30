package com.shynggysdimash.spring.rest.dao;

import com.shynggysdimash.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getAllEmployee(int id);

    public void deleteEmployee(int id);
}
