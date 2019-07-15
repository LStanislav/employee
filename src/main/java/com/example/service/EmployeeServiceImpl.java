package com.example.service;

import com.example.model.Employee;
import com.example.model.EmployeeGrade;
import com.example.model.Request;
import com.example.repository.EmployeeGradeRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.RequestRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;
    private final RequestRepository requestRepository;
    private final EmployeeGradeRepository employeeGradeRepository;

    public EmployeeServiceImpl(final EmployeeRepository employeeRepository, RequestRepository requestRepository, EmployeeGradeRepository employeeGradeRepository) {this.employeeRepository = employeeRepository;
        this.requestRepository = requestRepository;
        this.employeeGradeRepository = employeeGradeRepository;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        LOGGER.info("EmployeeServiceImpl#findAll");

        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee){employeeRepository.addEmployee(employee);}

    @Override
    @Transactional
    public List<Request> findRequestsByEmployee(Long employeeId) {

        LOGGER.info("RequestServiceImpl#findRequestsByEmployee");

        Employee employee = employeeRepository.findById(employeeId);

        final List<Long> requestIds = employee.getRequests().stream().map(Request::getId).collect(Collectors.toList());

        return requestIds.stream().map(requestRepository::findById).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<EmployeeGrade> findGradeByEmployee(Long employeeId) {

        LOGGER.info("RequestGradeImpl#findRequestsByEmployee");

        Employee employee = employeeRepository.findById(employeeId);

        final List<Long> gradeIds = employee.getEmployeeGrades().stream().map(EmployeeGrade::getId).collect(Collectors.toList());

        return gradeIds.stream().map(employeeGradeRepository::findById).collect(Collectors.toList());
    }
}











