package com.lattice.controller;

import com.lattice.entity.Doctor;
import com.lattice.service.DoctorService;
import com.lattice.service.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorController
{
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private Validation validation;

    // Adding Doctor API logic -
    @PostMapping("/assignment/doctor")
    String addingDoctor(@RequestBody Doctor doctor)
    {
        String validationString= validation.validationSetting(doctor);
        if(!validationString.equals("validated"))
            return validationString;
        return doctorService.savingDoctor(doctor);
    }

    // Removing Doctor API logic -
    @DeleteMapping("/assignment/doctor/{email}")
    String removingDoctor(@PathVariable String email)
    {
        return doctorService.deletingDoctor(email);
    }
}
