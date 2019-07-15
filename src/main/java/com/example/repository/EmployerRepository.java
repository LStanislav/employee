package com.example.repository;

import com.example.model.Employer;

import java.util.List;

public interface EmployerRepository {
    List<Employer> findAll();

    Employer findById(Long id);

    void addEmployer(Employer employer);
}
