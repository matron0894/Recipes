package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.domain.Recipe;
import recipes.service.IdRecipe;
import recipes.service.RecipeService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/new")
    public ResponseEntity<IdRecipe> createRecipe(@RequestBody @Valid Recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id) {
        return recipeService.findRecipeById(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable long id) {
        return recipeService.deleteRecipeById(id);
    }

}
