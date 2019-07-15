package com.example.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "employee")
public class Employee {
    private long id;
    private String name;
    private String surname;
    private Date birthDate;
    private double rating;
    private String description;
    private Country country;
//    private Request request;
    private Set<Request> requests;
    private Set<EmployeeGrade> employeeGrades;
    private String photo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
//    @DateTimeFormat(pattern = "MM-dd-yyyy")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "RATING") //, nullable = false, columnDefinition = "int default 5"
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
//    @Column(name = "COUNTRY")
    @JoinColumn(name = "country_id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Employee: id: " + id + " name: " + name + " surname: " + surname;
    }


    @OneToMany(mappedBy = "employee")
    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }

    @Column(name = "PHOTO_PATH")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @OneToMany(mappedBy = "employee")
    public Set<EmployeeGrade> getEmployeeGrades() {
        return employeeGrades;
    }

    public void setEmployeeGrades(Set<EmployeeGrade> employeeGrades) {
        this.employeeGrades = employeeGrades;
    }
}
