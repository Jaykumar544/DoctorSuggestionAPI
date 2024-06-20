package com.lattice.service;

import com.lattice.entity.Doctor;
import com.lattice.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService
{
    @Autowired
    private DoctorRepository doctorRepository;

    public String savingDoctor(Doctor doctor)
    {
        doctorRepository.save(doctor);
        return "Doctor record saved successfully.";
    }

    public String deletingDoctor(String email)
    {
        Optional<Doctor> doctorOptional = doctorRepository.findByEmail(email);
        if(doctorOptional.isPresent())
        {
            Doctor doctor = doctorOptional.get();
            doctorRepository.deleteById(doctor.getId());
            return "Doctor record deleted successfully.";
        }
        return "Doctor record not found with email - "+email;
    }
}
