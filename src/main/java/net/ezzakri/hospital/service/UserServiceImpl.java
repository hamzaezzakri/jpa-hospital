package net.ezzakri.hospital.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import net.ezzakri.hospital.Repositories.RoleRepository;
import net.ezzakri.hospital.Repositories.UserRepository;
import net.ezzakri.hospital.enteties.Role;
import net.ezzakri.hospital.enteties.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;


    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findUserByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findRoleByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = userRepository.findUserByUsername(userName);
        Role role = roleRepository.findRoleByRoleName(roleName);
        user.getRoles().add(role);
    }
}
