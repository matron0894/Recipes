package recipes.repos;

import org.springframework.data.repository.CrudRepository;
import recipes.domain.Recipe;

import java.util.ArrayList;
import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Optional<ArrayList<Recipe>> findByNameIgnoreCaseOrderByTimeDesc(String name);
    Optional<ArrayList<Recipe>> findByCategoryIgnoreCaseOrderByTimeDesc(String category);
 }
