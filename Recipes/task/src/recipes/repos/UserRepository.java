package recipes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import recipes.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional <User> findUserByEmail(String email);

}
