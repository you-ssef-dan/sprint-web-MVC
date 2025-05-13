package net.danoun.patientsapp.repository;

import net.danoun.patientsapp.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByNomContainingIgnoreCase(String keyword, Pageable pageable);
    Page<Patient> findByNomContainingIgnoreCaseOrPrenomContainsIgnoreCase(String nom, String prenom, Pageable pageable);
}
