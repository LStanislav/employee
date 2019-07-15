package com.example.service;

import com.example.model.Request;
import com.example.model.Vacancy;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by staliah on 04.06.2019.
 */
public interface RequestService {
    List<Request> findAll();

    Request findById(Long id);

    List<Vacancy> findVacancies(long id);

    void addRequest(Request request);

    void deleteRequest(long id);
}
