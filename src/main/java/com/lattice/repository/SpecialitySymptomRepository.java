package com.lattice.repository;

import com.lattice.entity.SpecialitySymptom;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.OneToOne;
import java.util.Optional;
public interface SpecialitySymptomRepository extends CrudRepository<SpecialitySymptom,Integer>
{
    Optional<SpecialitySymptom> findBySymptom(String symptom);
}
