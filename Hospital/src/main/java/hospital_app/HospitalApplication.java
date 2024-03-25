package hospital_app;

import hospital_app.entities.Consultation;
import hospital_app.entities.Medecin;
import hospital_app.entities.Patient;
import hospital_app.entities.RendezVous;
import hospital_app.enums.StatusRDV;
import hospital_app.repositories.ConsultationRepository;
import hospital_app.repositories.MedecinRepository;
import hospital_app.repositories.PatientRepository;
import hospital_app.repositories.RendezVousRepository;
import hospital_app.services.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.stream.Stream;


@SpringBootApplication
public class HospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository) {
        return args -> {

            // Question 8

            Stream.of("Ahmed", "Karim", "Jamal")
                    .forEach(nom -> {
                        Patient patient = Patient.builder()
                                .nom(nom)
                                .dateNaissance(LocalDate.now())
                                .malade(false)
                                .build();
                        hospitalService.save(patient);
                    });

            Stream.of("Soulaiman", "Najat", "Nisrine")
                    .forEach(nom -> {
                        Medecin medecin = Medecin.builder()
                                .nom(nom)
                                .specialite(Math.random() > 0.5 ? "Generaliste" : "Ophtalmologue")
                                .email(nom + "@mail.com")
                                .build();
                        hospitalService.save(medecin);
                    });

            // Relation Medecin - RDV - Patient
            Medecin nisrineMedecin = medecinRepository.findMedecinByNomIgnoreCase("nisrine");
            Patient ahmedPatient = patientRepository.findPatientByNomIgnoreCase("ahmed");
            RendezVous NisrineAhmedRDV1 = RendezVous.builder()
                    .medecin(nisrineMedecin)
                    .patient(ahmedPatient)
                    .date(LocalDate.now())
                    .status(StatusRDV.PENDING)
                    .build();
            hospitalService.save(NisrineAhmedRDV1);


            // Consultation - RDV
            RendezVous rendezVous = rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(LocalDate.now());
            consultation.setRendezVous(rendezVous);
            hospitalService.save(consultation);


            // Questions 1 -> 7
/*
        System.out.println("\n************ Ajouter les patients ************");

        this.patientRepository.save(
                new Patient(
                        null,
                        "Ahmed",
                        LocalDate.of(2000, Month.JANUARY.getValue(), 6),
                        true,
                        47
                ));
        this.patientRepository.save(
                new Patient(
                        null,
                        "Karim",
                        LocalDate.of(1987, Month.DECEMBER.getValue(), 14),
                        true,
                        12
                ));
        this.patientRepository.save(
                new Patient(
                        null,
                        "Jamal",
                        LocalDate.of(2005, Month.APRIL.getValue(), 28),
                        true,
                        98
                ));


        System.out.println("\n************ Consulter les patients ************");
        List<Patient> patientList = patientRepository.findAll();
        patientList.forEach(System.out::println);

        System.out.println("\n************ Consulter un patient ************");
        Patient patient = patientRepository.findById(2L).get();
        System.out.println(patient);

        System.out.println("\n************ Chercher les patients ************");
        List<Patient> patientsMaladesNesApres2000 = patientRepository.findPatientsByDateNaissanceAfterAndMalade(
                LocalDate.of(1999, Month.DECEMBER, 31),
                true
        );
        patientsMaladesNesApres2000.forEach(System.out::println);

        System.out.println("\n************ Supprimer un patient ************");
        // supprimer karim
        Patient karim = patientRepository.findPatientByNomIgnoreCase("karim");
        patientRepository.delete(karim);
        System.out.println("Deleting " + karim.getNom());


        System.out.println("\n************ Modifier un patient ************");
        // modifier ahmed
        Patient ahmed = patientRepository.findPatientByNomIgnoreCase("ahmed");
        ahmed.setNom("ahmed (modified)");
        ahmed.setMalade(false);
        System.out.println("Modifying " + ahmed.getNom());

        System.out.println("\n************ Migration vers MYSQL voir application.properties ************");

*/

        };
    }
}
