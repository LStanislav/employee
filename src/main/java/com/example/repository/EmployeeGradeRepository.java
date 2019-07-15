package com.example.repository;

import com.example.model.EmployeeGrade;

import java.util.List;

public interface EmployeeGradeRepository {

    List<EmployeeGrade> findAll();

    EmployeeGrade findById(long id);

}
