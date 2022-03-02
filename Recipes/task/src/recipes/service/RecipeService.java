package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import recipes.domain.Recipe;
import recipes.repos.RecipeRepository;

import java.time.LocalTime;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    public ResponseEntity<String> saveRecipe(Recipe recipe) {
        try {
            Recipe newRecipe = recipeRepository
                    .save(new Recipe(recipe.getName(),
                            recipe.getDescription(),
                            recipe.getIngredients(),
                            recipe.getDirections()
                    ));

            return new ResponseEntity<>(String.format("{\"id\": %d}", newRecipe.getId()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<Recipe> findRecipeById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found for id = " + id);
        return new ResponseEntity<>(recipe.get(), HttpStatus.OK);
    }


    public ResponseEntity<HttpStatus> deleteRecipeById(Long id) {
        Optional<Recipe> recipeDel = recipeRepository.findById(id);
        if (recipeDel.isPresent()) {
            recipeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}