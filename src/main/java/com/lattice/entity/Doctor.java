package com.lattice.entity;

import org.springframework.stereotype.Component;
import javax.persistence.*;

@Component
@Entity
public class Doctor
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private String email;
    private String name;
    private String city;
    private String phoneNo;
    private String speciality;

    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}