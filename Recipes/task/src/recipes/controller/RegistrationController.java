package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import recipes.domain.User;
import recipes.service.UserService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class RegistrationController {

    @Autowired
    UserService userService;

    @PostMapping("/api/register")
    public ResponseEntity<HttpStatus> register(@Valid @RequestBody User user) {
        // input validation omitted for brevity
        Optional<User> userFromDB = userService.findUser(user.getEmail());

        if (userFromDB.isEmpty()) userService.addNewUser(user);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

