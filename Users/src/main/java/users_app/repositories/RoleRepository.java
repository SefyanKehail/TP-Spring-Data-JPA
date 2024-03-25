package users_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import users_app.entites.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRoleName(String roleName);
}
