package users_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import users_app.entites.Role;
import users_app.entites.User;
import users_app.services.contracts.IUserService;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class UsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IUserService userService) {
        return args -> {

            Stream.of("AhmedStudent", "KarimAdmin", "JamalUser")
                    .forEach(username -> {
                        User user = new User();
                        user.setUsername(username);
                        user.setPassword("123");
                        userService.addNewUser(user);
                    });

            Stream.of("STUDENT", "ADMIN", "USER")
                    .forEach(roleName -> {
                        Role role = new Role();
                        role.setRoleName(roleName);
                        role.setDescription("description du role: " + roleName);
                        userService.addNewRole(role);
                    });

            userService.addRoleToUser("AhmedStudent", "STUDENT");
            userService.addRoleToUser("JamalUser", "USER");
            userService.addRoleToUser("KarimAdmin", "ADMIN");
            userService.addRoleToUser("KarimAdmin", "USER");

            try {
                System.out.println("\n**************** Authentication Attempt ****************");
                User user2 = userService.authenticate("KarimAdmin", "123");
                System.out.println("UserId: " + user2.getUserId());
                System.out.println("Username: " + user2.getUsername());
                System.out.println("Roles =>");
                user2.getRoles().forEach(role -> System.out.println("\tRole -> " + role.getRoleName()));

                System.out.println("\n**************** Authentication Attempt ****************");
                User user1 = userService.authenticate("AhmedStudent", "wrongPassword");
                System.out.println("UserId: " + user1.getUserId());
                System.out.println("Username: " + user1.getUsername());
                System.out.println("Roles =>");
                user1.getRoles().forEach(role -> System.out.println("Role -> " + role.getRoleName()));



            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }


        };
    }
}
