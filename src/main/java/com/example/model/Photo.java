//package com.example.model;
//
//import javax.persistence.*;
//
///**
// * Created by staliah on 26.06.2019.
// */
//
//@Entity
//public class Photo {
//    private long id;
//    private byte[] photo;
//    private Employee employee;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "PHOTO_ID")
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    @Column(name = "PHOTO")
//    public byte[] getPhoto() {
//        return photo;
//    }
//
//    public void setPhoto(byte[] photo) {
//        this.photo = photo;
//    }
//
//    @OneToOne(mappedBy = "photo")
//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//}
