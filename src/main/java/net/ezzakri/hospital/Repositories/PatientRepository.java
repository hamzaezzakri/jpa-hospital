package net.ezzakri.hospital.Repositories;

import net.ezzakri.hospital.enteties.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository  extends JpaRepository<Patient, Long> {

    Patient findByNom(String name);
}
