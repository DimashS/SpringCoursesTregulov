package com.shynggysdimash.spring.springboot.springboot_rest.dao;


import com.shynggysdimash.spring.springboot.springboot_rest.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager; // создается автоматически (для Hibernate session) => обертка сессии

    @Override
    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class); // unwrap обертку
//
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmployees = query.getResultList();
        Query query = entityManager.createQuery("from Employee"); // without Generic
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class); // unwrap обертку
//        session.saveOrUpdate(employee);
        Employee employee1 = entityManager.merge(employee); // saveOrUpdate то же самое
        employee.setId(employee1.getId());
    }


    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class); // unwrap обертку
//        Employee employee = session.get(Employee.class, id);
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class); // unwrap обертку
//        Query<Employee> query = session.createQuery("delete from Employee where id=:employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();
        Query query = entityManager.createQuery("delete from Employee " +
                "where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();

    }
}
