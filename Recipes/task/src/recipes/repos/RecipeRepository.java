package recipes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import recipes.domain.Recipe;

import java.util.ArrayList;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Optional<ArrayList<Recipe>> findAllByNameContainingIgnoreCaseOrderByDateDesc(String name);
    Optional<ArrayList<Recipe>> findByCategoryIgnoreCaseOrderByDateDesc(String category);
 }
