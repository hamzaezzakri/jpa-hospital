package net.ezzakri.hospital.service;

import jakarta.transaction.Transactional;
import net.ezzakri.hospital.Repositories.ConsultationRepository;
import net.ezzakri.hospital.Repositories.MedecinRepository;
import net.ezzakri.hospital.Repositories.PatientRepository;
import net.ezzakri.hospital.Repositories.RendezVousRepository;
import net.ezzakri.hospital.enteties.Consultation;
import net.ezzakri.hospital.enteties.Medecin;
import net.ezzakri.hospital.enteties.Patient;
import net.ezzakri.hospital.enteties.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {

    PatientRepository patientRepository;
    MedecinRepository medecinRepository;
    RendezVousRepository rendezVousRepository;

    public IHospitalServiceImpl(PatientRepository patientRepository,
                                MedecinRepository medecinRepository,
                                RendezVousRepository rendezVousRepository,
                                ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    ConsultationRepository consultationRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
