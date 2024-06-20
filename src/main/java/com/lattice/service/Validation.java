package com.lattice.service;

import com.lattice.entity.Doctor;
import com.lattice.entity.Patient;
import org.springframework.stereotype.Service;

@Service
public class Validation
{
    public String validationSetting(Doctor doctor)
    {
        if(doctor.getName().length()<3)
            return "Name must contain at least 3 characters.";
        if(!(doctor.getEmail().indexOf('@')!= -1 && doctor.getEmail().indexOf('.')!= -1 ))
            return "Invalid email entered.";
        if(doctor.getCity().length()>20)
            return "City must containt less than or equal to 20 characters.";
        if(!(doctor.getCity().equals("Delhi") || doctor.getCity().equals("Noida") || doctor.getCity().equals("Faridabad")))
            return "City value must be (Delhi/Noida/Faridabad) only.";
        if(doctor.getPhoneNo().length()<10)
            return "Phone no. must contain at least 10 numbers.";
        if(!(doctor.getSpeciality().equals("Orthopedic") || doctor.getSpeciality().equals("Gynecology") || doctor.getSpeciality().equals("Dermatology") || doctor.getSpeciality().equals("ENT")))
            return "Speciality value must be (Orthopedic/Gynecology/Dermatology/ENT) only.";
        return "validated";
    }

    public String validationSetting(Patient patient)
    {
        if(patient.getName().length()<3)
            return "Name must contain at least 3 characters.";
        if(!(patient.getEmail().indexOf('@')!= -1 && patient.getEmail().indexOf('.')!= -1 ))
            return "Invalid email entered.";
        if(patient.getCity().length()>20)
            return "City must containt less than or equal to 20 characters.";
        if(patient.getPhoneNo().length()<10)
            return "Phone no. must contain at least 10 numbers.";
        return "validated";
    }
}
