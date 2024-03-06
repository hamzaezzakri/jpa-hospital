package net.ezzakri.hospital.Repositories;

import net.ezzakri.hospital.enteties.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String name);
}
