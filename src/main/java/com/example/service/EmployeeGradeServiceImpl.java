package com.example.service;

import com.example.model.EmployeeGrade;
import com.example.repository.EmployeeGradeRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EmployeeGradeServiceImpl implements EmployeeGradeService {

    private static final Logger LOGGER = Logger.getLogger(EmployeeGradeServiceImpl.class);


    private final EmployeeGradeRepository employeeGradeRepository;

    public EmployeeGradeServiceImpl(EmployeeGradeRepository employeeGradeRepository) {
        this.employeeGradeRepository = employeeGradeRepository;
    }

    @Override
    @Transactional
    public List<EmployeeGrade> findAll() {
        return employeeGradeRepository.findAll();
    }

    @Override
    @Transactional
    public EmployeeGrade findById(long id) {
        return employeeGradeRepository.findById(id);
    }
}
