package com.lattice.controller;

import com.lattice.entity.Patient;
import com.lattice.service.PatientService;
import com.lattice.service.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController
{
    @Autowired
    private PatientService patientService;
    @Autowired
    private Validation validation;

    // Adding Patient API logic -
    @PostMapping("/assignment/patient")
    String addingPatient(@RequestBody Patient patient)
    {
        String validationString= validation.validationSetting(patient);
        if(!validationString.equals("validated"))
            return validationString;
        return patientService.savingPatient(patient);
    }

    // Removing Patient API logic -
    @DeleteMapping("/assignment/patient/{email}")
    String deletingPatient(@PathVariable String email)
    {
        return patientService.deletingPatient(email);
    }
}
