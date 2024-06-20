package com.lattice.controller;

import com.lattice.entity.Doctor;
import com.lattice.entity.Patient;
import com.lattice.entity.SpecialitySymptom;
import com.lattice.repository.DoctorRepository;
import com.lattice.repository.PatientRepository;
import com.lattice.repository.SpecialitySymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lattice.exceptions.custom.*;
import java.util.List;
import java.util.Optional;

@RestController
public class SuggestionController
{
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private SpecialitySymptomRepository specialitySymptomRepository;

    // Doctor suggestion API logic -
    @GetMapping("/assignment/suggestedDoctors/{patientId}")
    List<Doctor> gettingListOfDoctors(@PathVariable Integer patientId) throws Exception
    {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if(optionalPatient.isPresent())
        {
            Patient patient = optionalPatient.get();
            Optional<SpecialitySymptom> optionalSpecialitySymptom = specialitySymptomRepository.findBySymptom(patient.getSymptom());

            if(optionalSpecialitySymptom.isPresent())
            {
                SpecialitySymptom specialitySymptom = optionalSpecialitySymptom.get();
                List<Doctor> doctors = doctorRepository.findByCityAndSpeciality(patient.getCity(), specialitySymptom.getSpeciality());

                if(doctors.isEmpty())
                    throw new DoctorNotFoundException();
                return doctors;
            }
            else
                throw new SymptomNotFoundException();
        }
        else
            throw new PatientNotFoundException();
    }
}
