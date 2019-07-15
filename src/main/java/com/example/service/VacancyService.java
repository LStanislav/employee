package com.example.service;

import com.example.model.Request;
import com.example.model.Vacancy;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by staliah on 04.06.2019.
 */
public interface VacancyService {
    List<Vacancy> findAll();

    Vacancy findById(Long id);

    List<Request> findRequests(long id);

    void addVacancy(Vacancy vacancy);

    void deleteVacancy(long id);
}
