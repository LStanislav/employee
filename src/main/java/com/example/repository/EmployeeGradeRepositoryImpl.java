package com.example.repository;

import com.example.model.EmployeeGrade;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeGradeRepositoryImpl implements EmployeeGradeRepository {

    private static final Logger LOGGER = Logger.getLogger(EmployeeGradeRepositoryImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<EmployeeGrade> findAll() {
        LOGGER.info("EmployeeGradeRepositoryImpl#findAll");

        return sessionFactory.getCurrentSession().createQuery("SELECT e FROM employee_grade e").list();
    }

    @Override
    public EmployeeGrade findById(long id) {
        LOGGER.info("EmployeeGradeRepositoryImpl#findById");

        return (EmployeeGrade) sessionFactory.getCurrentSession().createQuery("SELECT g FROM employee_grade g WHERE g.id = " + id).uniqueResult();
    }
}
