package net.danoun.patientsapp;

import net.danoun.patientsapp.entities.Patient;
import net.danoun.patientsapp.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(PatientRepository patientRepository) {
        return args -> {
            Patient p1 = new Patient();
            p1.setNom("danoun");
            p1.setPrenom("youssef");
            p1.setDateNaissance(new Date());
            p1.setScore(7);
            p1.setMalade(false);

            Patient p2 = new Patient(null,"chidoub", "reda", new Date(),10,false);

            Patient p3 = Patient.builder()
                    .nom("ait ben")
                    .prenom("adam")
                    .dateNaissance(new Date())
                    .malade(true)
                    .score(20)
                    .build();

            patientRepository.save(p1);
            patientRepository.save(p2);
            patientRepository.save(p3);

            patientRepository.findAll().forEach(p -> {
                System.out.println(p.toString());
            });
        };
    }

}
