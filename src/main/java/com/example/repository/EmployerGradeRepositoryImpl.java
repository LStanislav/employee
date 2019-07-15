package com.example.repository;

import com.example.model.EmployerGrade;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployerGradeRepositoryImpl implements EmployerGradeRepository {

    private static final Logger LOGGER = Logger.getLogger(EmployerGradeRepositoryImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<EmployerGrade> findAll() {
        LOGGER.info("EmployerGradeRepositoryImpl#findAll");

        return sessionFactory.getCurrentSession().createQuery("SELECT g FROM employer_grade g").list();
    }

    @Override
    public EmployerGrade findById(long id) {
        LOGGER.info("EmployerGradeRepositoryImpl#findById");

        return (EmployerGrade) sessionFactory.getCurrentSession().createQuery("SELECT g FROM employer_grade g WHERE g.id = " + id).uniqueResult();
    }
}
