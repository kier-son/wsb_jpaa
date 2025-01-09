package com.jpacourse.repository;

import com.jpacourse.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    // Znajdź pacjentów po nazwisku
    List<PatientEntity> findByLastName(String lastName);

    // Znajdź pacjentów, którzy mieli więcej niż X wizyt
    @Query("SELECT p FROM PatientEntity p WHERE SIZE(p.visits) > :visitCount")
    List<PatientEntity> findPatientsWithMoreThanXVisits(@Param("visitCount") int visitCount);

    // Znajdź pacjentów po nowym polu (np. healthScore > minimalny próg)
    @Query("SELECT p FROM PatientEntity p WHERE p.healthScore > :minScore")
    List<PatientEntity> findByHealthScoreGreaterThan(@Param("minScore") int minScore);
}
