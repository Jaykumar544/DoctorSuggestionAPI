package com.lattice.entity;

import org.springframework.stereotype.Component;
import javax.persistence.*;

@Component
@Entity
@Table(name = "specialitysymptom")
public class SpecialitySymptom
{
    @Id
    private int id;
    private String speciality;
    private String symptom;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    public String getSymptom() {
        return symptom;
    }
    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
}
