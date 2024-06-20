package com.lattice.repository;

import com.lattice.entity.Doctor;
import com.lattice.entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PatientRepository extends CrudRepository<Patient,Integer>
{
    void deleteById(Integer id);
    Optional<Patient> findByEmail(String email);
}
