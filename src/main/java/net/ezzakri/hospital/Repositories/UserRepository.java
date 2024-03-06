package net.ezzakri.hospital.Repositories;

import net.ezzakri.hospital.enteties.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findUserByUsername(String username);
}
