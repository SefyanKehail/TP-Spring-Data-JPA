package hospital_app.repositories;

import hospital_app.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
