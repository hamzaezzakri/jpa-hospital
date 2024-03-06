package net.ezzakri.hospital.Repositories;

import net.ezzakri.hospital.enteties.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByRoleName(String roleName);
}
