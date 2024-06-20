package com.lattice.service;

import com.lattice.entity.Patient;
import com.lattice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService
{
    @Autowired
    private PatientRepository patientRepository;

    public String savingPatient(Patient patient)
    {
        patientRepository.save(patient);
        return "Patient record save successfully.";
    }

    public String deletingPatient(String email)
    {
        Optional<Patient> patientOptional = patientRepository.findByEmail(email);
        if(patientOptional.isPresent())
        {
            Patient patient = patientOptional.get();
            patientRepository.deleteById(patient.getId());
            return "Patient record deleted successfully.";
        }
        return "Patient record not found with email - "+email;
    }
}
