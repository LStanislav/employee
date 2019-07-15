package com.example.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by staliah on 03.06.2019.
 */

@Entity(name = "country")
public class Country {
    private long id;
    private String name;
    private Set<Employee> employees;
    private Set<Request> requests;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUNTRY_ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "COUNTRY_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "country")
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }


    @OneToMany(mappedBy = "country")
    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }

}
