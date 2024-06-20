package com.lattice.repository;

import com.lattice.entity.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor,Integer>
{
    void deleteById(Integer id);
    Optional<Doctor> findByEmail(String email);
    List<Doctor> findByCityAndSpeciality(String city, String  speciality);
}
