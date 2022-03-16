package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import recipes.domain.User;
import recipes.repos.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository myUserRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = myUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addNewUser(User myUser) {
        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
        userRepository.save(myUser);
    }

    public Optional<User> findUser(String email) {
        return userRepository.findUserByEmail(email);

    }

}
