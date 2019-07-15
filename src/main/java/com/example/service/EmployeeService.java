package com.example.service;

import com.example.model.Employee;
import com.example.model.EmployeeGrade;
import com.example.model.Request;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(Long id);

	void addEmployee(Employee employee);

	List<Request> findRequestsByEmployee(Long employeeId);

	List<EmployeeGrade> findGradeByEmployee(Long employeeId);
}
