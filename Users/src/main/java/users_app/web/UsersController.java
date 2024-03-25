package users_app.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import users_app.entites.User;
import users_app.services.contracts.IUserService;

@RestController @AllArgsConstructor
public class UsersController {
    private IUserService userService;

    @GetMapping("/users/{username}")
    public User user(@PathVariable String username){
        return userService.findUserByUsername(username);
    }
}
