package com.example.service;

import com.example.model.Employer;
import com.example.model.EmployerGrade;
import com.example.model.Vacancy;

import java.util.List;

/**
 * Created by staliah on 05.06.2019.
 */
public interface EmployerService {
    List<Employer> findAll();

   Employer findById(Long id);

    void addEmployer(Employer employer);

    List<Vacancy> findVacancyByEmployer(Long employerId);

    List<EmployerGrade> findGradeByEmployer(Long employerId);
}
