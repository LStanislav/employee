package com.example.service;


import com.example.model.EmployerGrade;

import java.util.List;

public interface EmployerGradeService {

    List<EmployerGrade> findAll();

    EmployerGrade findById(long id);

}
