package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.domain.Recipe;
import recipes.service.IdRecipe;
import recipes.service.RecipeService;

import java.util.Optional;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable int id) {
        Optional<Recipe> recipe = recipeService.findById(id);
        if (recipe.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(recipe.get(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<IdRecipe> saveRecipe(@RequestBody Recipe recipe) {
        Integer id = recipeService.save(recipe);
        IdRecipe dto = new IdRecipe(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
