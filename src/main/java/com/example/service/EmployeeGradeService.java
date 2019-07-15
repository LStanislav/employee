package com.example.service;

import com.example.model.EmployeeGrade;

import java.util.List;

public interface EmployeeGradeService {

    List<EmployeeGrade> findAll();

    EmployeeGrade findById(long id);

}
