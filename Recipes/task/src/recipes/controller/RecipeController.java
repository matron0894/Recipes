package recipes.controller;

import org.springframework.web.bind.annotation.*;
import recipes.domain.Recipe;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private Recipe recipe;

    @PostMapping
    public void saveRecipe(@RequestBody Recipe recipe) {
        this.recipe = recipe;
    }

    @GetMapping
    public Recipe getRecipe() {
        return recipe;
    }
}
