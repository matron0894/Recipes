package recipes.repos;

import org.springframework.data.repository.CrudRepository;
import recipes.domain.Kitchener;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Kitchener, Long> {

    Optional <Kitchener> findByEmail(String email);

}
