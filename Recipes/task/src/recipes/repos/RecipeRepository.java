package recipes.repos;

import org.springframework.data.repository.CrudRepository;
import recipes.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
