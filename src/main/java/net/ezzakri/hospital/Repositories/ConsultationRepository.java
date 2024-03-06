package net.ezzakri.hospital.Repositories;

import net.ezzakri.hospital.enteties.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
