package com.shynggysdimash.spring.springboot.spring_data_jpa.dao;





import com.shynggysdimash.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // 1. Generic с каким Entity,
    // 2. Primary Key

    public List<Employee> findAllByName(String name);
}
