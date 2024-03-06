package net.ezzakri.hospital.service;

import net.ezzakri.hospital.enteties.Consultation;
import net.ezzakri.hospital.enteties.Medecin;
import net.ezzakri.hospital.enteties.Patient;
import net.ezzakri.hospital.enteties.RendezVous;

public interface IHospitalService {

    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
