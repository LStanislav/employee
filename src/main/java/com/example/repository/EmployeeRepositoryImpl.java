package com.example.repository;

import com.example.model.Employee;
import com.example.model.Request;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static final Logger LOGGER = Logger.getLogger(EmployeeRepositoryImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> findAll() {
        LOGGER.info("EmployeeRepositoryImpl#findAll");

        return sessionFactory.getCurrentSession().createQuery("SELECT e FROM employee e").list();
    }

    @Override
    public Employee findById(Long id) {
        LOGGER.info("EmployeeRepositoryImpl#findById");

        return (Employee) sessionFactory.getCurrentSession().createQuery("SELECT e FROM employee e WHERE e.id   =" + id).uniqueResult();
    }

    @Override
    public void addEmployee(Employee empl){
        LOGGER.info("EmployeeRepositoryImpl#addEmployee");

        sessionFactory.getCurrentSession().save(empl);
    }

}
