package users_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import users_app.entites.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserByUsername(String username);
}
