package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import recipes.domain.Recipe;
import recipes.repos.RecipeRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
                            recipe.getCategory(),
//                            LocalDateTime.now(),
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


    public ResponseEntity<List<Recipe>> findRecipeByName(String name) {
        Optional<ArrayList<Recipe>> recipes = recipeRepository.findAllByNameContainingIgnoreCaseOrderByDateDesc(name);
        List<Recipe> result;
        if (recipes.isEmpty()) result = Collections.emptyList();
        else result = recipes.get();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<List<Recipe>> findRecipeByCategory(String category) {
        Optional<ArrayList<Recipe>> recipes = recipeRepository.findByCategoryIgnoreCaseOrderByDateDesc(category);
        List<Recipe> result;
        if (recipes.isEmpty()) result = Collections.emptyList();
        else result = recipes.get();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    public ResponseEntity<List<Recipe>> searchByQueryParam(String name, String category) {
        Optional<String> opName = Optional.ofNullable(name);
        Optional<String> opCategory = Optional.ofNullable(category);
        if (opName.isPresent() && opCategory.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (!opName.isPresent() && !opCategory.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            if (opName.isPresent()) return findRecipeByName(name);
            else return findRecipeByCategory(category);
        }
    }


    public ResponseEntity<HttpStatus> updateRecipeById(Long id, Recipe recipe) {
        Optional<Recipe> oldRecipe = recipeRepository.findById(id);
        if (oldRecipe.isPresent()) {
            Recipe newRec = oldRecipe.get();
            newRec.setName(recipe.getName());
            newRec.setCategory(recipe.getCategory());
            newRec.setDescription(recipe.getDescription());
            newRec.setIngredients(recipe.getIngredients());
            newRec.setDirections(recipe.getDirections());
            recipeRepository.save(newRec);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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