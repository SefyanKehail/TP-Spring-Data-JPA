package users_app.services.implementations;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import users_app.entites.Role;
import users_app.entites.User;
import users_app.repositories.RoleRepository;
import users_app.repositories.UserRepository;
import users_app.services.contracts.IUserService;

@Service
@Transactional
@AllArgsConstructor
public class IUserServiceImpl implements IUserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findRoleByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = this.findUserByUsername(username);
        Role role = this.findRoleByRoleName(roleName);
        user.getRoles().add(role);
        role.getUsers().add(user); // Not sure how JPA handles this, it may cause performance issues
        // no need to flush since the Service is Transactional
    }

    @Override
    public User authenticate(String username, String password) {
        User user = this.findUserByUsername(username);
        if (user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Wrong credentials");
    }
}
