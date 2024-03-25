package hospital_app.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private LocalDate dateNaissance;

    private boolean malade;

    @OneToMany(mappedBy = "patient", targetEntity = RendezVous.class, fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;
}
