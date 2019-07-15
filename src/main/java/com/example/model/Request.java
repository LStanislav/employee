package com.example.model;

import javax.persistence.*;

/**
 * Created by staliah on 04.06.2019.
 */

@Entity(name = "request")
public class Request {

    private long id;
    private Country country;
    private Profession profession;
    private int minSalary;
    private int maxSalary;
    private boolean house;
    private Employee employee;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REQ_ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //    @Column(name = "REQ_COUNTRY")
    @ManyToOne
    @JoinColumn(name = "country_id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    //    @Column(name = "REQ_PROFESSION")
    @ManyToOne
    @JoinColumn(name = "prof_id")
    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }



    @Column(name = "MIN_SALARY")
    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    @Column(name = "MAX_SALARY")
    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Column(name = "HOUSE")
//    @Value(value = "false")
    public boolean getHouse() {
        return house;
    }

    public void setHouse(boolean house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Request: id: " + id + " country: " + country.getName() + " profession: " + profession.getName();
    }

    @ManyToOne
    @JoinColumn(name = "empl_id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
