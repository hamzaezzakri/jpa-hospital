package net.ezzakri.hospital.service;

import net.ezzakri.hospital.enteties.Role;
import net.ezzakri.hospital.enteties.User;

public interface UserService {

    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName, String roleName);
}
