package hospital_app.repositories;

import hospital_app.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findPatientByNomIgnoreCase(String nom);
}
