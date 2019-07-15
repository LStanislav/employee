package com.example.repository;

import com.example.model.Employee;
import com.example.model.EmployeeGrade;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findAll();

    Employee findById(Long id);

    void addEmployee(Employee employee);
}
