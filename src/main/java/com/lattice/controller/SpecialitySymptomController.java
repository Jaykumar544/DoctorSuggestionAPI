package com.lattice.controller;

import com.lattice.entity.SpecialitySymptom;
import com.lattice.repository.SpecialitySymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpecialitySymptomController
{
    @Autowired
    SpecialitySymptomRepository specialitySymptomRepository;

    // Adding Symptom and Speciality API logic -
    @PostMapping("/assignment/addSymptomWithSpeciality")
    String addingSpecialitySymptom(@RequestBody SpecialitySymptom specialitySymptom)
    {
        specialitySymptomRepository.save(specialitySymptom);
        return "record saved.";
    }
}
