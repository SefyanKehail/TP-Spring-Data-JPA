package users_app.services.contracts;

import users_app.entites.Role;
import users_app.entites.User;

public interface IUserService {
    User addNewUser(User user);

    Role addNewRole(Role role);

    User findUserByUsername(String username);

    Role findRoleByRoleName(String roleName);

    void addRoleToUser(String username, String roleName);

    User authenticate(String username, String password);
}
