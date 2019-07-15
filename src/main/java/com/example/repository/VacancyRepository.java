package com.example.repository;

import com.example.model.Request;
import com.example.model.Vacancy;

import java.util.List;

/**
 * Created by staliah on 04.06.2019.
 */
public interface VacancyRepository {
    List<Vacancy> findAll();

    Vacancy findById(Long id);

    List<Request> findRequest(Long id);

    void addVacancy(Vacancy vacancy);

    void deleteVacancy(Long id);
}
