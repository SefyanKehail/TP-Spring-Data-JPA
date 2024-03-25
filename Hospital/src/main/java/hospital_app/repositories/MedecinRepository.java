package hospital_app.repositories;

import hospital_app.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findMedecinByNomIgnoreCase(String nom);
}
