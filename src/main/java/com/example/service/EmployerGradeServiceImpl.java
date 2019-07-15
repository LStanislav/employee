package com.example.service;

import com.example.model.EmployerGrade;
import com.example.repository.EmployerGradeRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EmployerGradeServiceImpl implements EmployerGradeService {

    private static final Logger LOGGER = Logger.getLogger(EmployerGradeServiceImpl.class);


    private final EmployerGradeRepository employerGradeRepository;

    public EmployerGradeServiceImpl(EmployerGradeRepository employerGradeRepository) {
        this.employerGradeRepository = employerGradeRepository;
    }


    @Override
    @Transactional
    public List<EmployerGrade> findAll() {
        return employerGradeRepository.findAll();
    }

    @Override
    @Transactional
    public EmployerGrade findById(long id) {
        return employerGradeRepository.findById(id);
    }
}
