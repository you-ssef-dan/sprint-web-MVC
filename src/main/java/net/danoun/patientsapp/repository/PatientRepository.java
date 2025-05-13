package net.danoun.patientsapp.repository;

import net.danoun.patientsapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
