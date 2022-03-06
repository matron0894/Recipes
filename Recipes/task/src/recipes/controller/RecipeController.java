package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.domain.Recipe;
import recipes.service.RecipeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<String> createRecipe( @Valid  @RequestBody Recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }


    @GetMapping("/search")
    @ResponseBody
    public ResponseEntity<List<Recipe>> searchRecipesByName(@Valid @RequestParam(value = "name", required = false) String name,@Valid @RequestParam(value = "category", required = false) String category) {
        return recipeService.searchByQueryParam(name, category);
    }

//    @GetMapping("/search")
//    @ResponseBody
//    public ResponseEntity<List<Recipe>> searchRecipesByCategory(@Valid @RequestParam("category") String category) {
//        return recipeService.findRecipeByCategory(category);
//    }


    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@Valid @PathVariable long id) {
        return recipeService.findRecipeById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<HttpStatus> updateRecipe(@Valid @PathVariable long id, @Valid @RequestBody Recipe newRecipe) {
        return recipeService.updateRecipeById(id, newRecipe);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRecipe(@Valid @PathVariable long id) {
        return recipeService.deleteRecipeById(id);
    }

}
