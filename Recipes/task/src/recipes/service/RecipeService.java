package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Long saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return recipe.getId();
    }

    public Optional<Recipe> findRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    public List<Recipe> findRecipeByName(String name) {
        Optional<ArrayList<Recipe>> recipes = recipeRepository.findAllByNameContainingIgnoreCaseOrderByDateDesc(name);
        if (recipes.isEmpty()) return Collections.emptyList();
        else return recipes.get();
    }

    public List<Recipe> findRecipeByCategory(String category) {
        Optional<ArrayList<Recipe>> recipes = recipeRepository.findByCategoryIgnoreCaseOrderByDateDesc(category);
        if (recipes.isEmpty()) return Collections.emptyList();
        else return recipes.get();
    }

    public Optional<Recipe> updateRecipeById(Long id, Recipe recipe) {
        Optional<Recipe> oldRecipe = recipeRepository.findById(id);
        if (oldRecipe.isPresent()) {
            Recipe newRec = oldRecipe.get();
            newRec.setName(recipe.getName());
            newRec.setCategory(recipe.getCategory());
            newRec.setDescription(recipe.getDescription());
            newRec.setIngredients(recipe.getIngredients());
            newRec.setDirections(recipe.getDirections());
            recipeRepository.save(newRec);
        }
        return oldRecipe;
    }

    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }


}