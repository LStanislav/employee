package com.example.repository;

import com.example.model.Request;
import com.example.model.Vacancy;

import java.util.List;

/**
 * Created by staliah on 04.06.2019.
 */
public interface RequestRepository {
    List<Request> findAll();

    Request findById(Long id);

    List<Vacancy> findVacancies(Long id);

    void addRequest(Request request);

    void deleteRequest(Long id);
}
