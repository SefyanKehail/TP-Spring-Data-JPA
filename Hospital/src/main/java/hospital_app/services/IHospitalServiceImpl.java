package hospital_app.services;

import hospital_app.entities.Consultation;
import hospital_app.entities.Medecin;
import hospital_app.entities.Patient;
import hospital_app.entities.RendezVous;
import hospital_app.repositories.ConsultationRepository;
import hospital_app.repositories.MedecinRepository;
import hospital_app.repositories.PatientRepository;
import hospital_app.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;


    public IHospitalServiceImpl(
            PatientRepository patientRepository, MedecinRepository medecinRepository,
            RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository
    ) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin save(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous save(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation save(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
