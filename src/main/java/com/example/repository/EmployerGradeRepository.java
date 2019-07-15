package com.example.repository;

import com.example.model.EmployeeGrade;
import com.example.model.EmployerGrade;

import java.util.List;

public interface EmployerGradeRepository {

    List<EmployerGrade> findAll();

    EmployerGrade findById(long id);

}
