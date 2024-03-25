package hospital_app.services;

import hospital_app.entities.Consultation;
import hospital_app.entities.Medecin;
import hospital_app.entities.Patient;
import hospital_app.entities.RendezVous;
import hospital_app.repositories.PatientRepository;

public interface IHospitalService {
    Patient save(Patient patient);
    Medecin save(Medecin medecin);
    RendezVous save(RendezVous rendezVous);
    Consultation save(Consultation consultation);
}
