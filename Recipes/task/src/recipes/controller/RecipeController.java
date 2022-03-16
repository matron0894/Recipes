package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.domain.Recipe;
import recipes.service.RecipeService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/api/recipe/")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("new")
    @ResponseBody
    public ResponseEntity<Map<String, Long>> createRecipe(@Valid @RequestBody Recipe recipe, Principal principal) {
        try {
            String creator = principal.getName();
            long id = recipeService.saveRecipe(recipe, creator);
            return new ResponseEntity<>(Map.of("id", id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("search")
    @ResponseBody
    public ResponseEntity<List<Recipe>> searchRecipesByParams(@RequestParam Map<String, String> param) {
        if (param.size() == 1 && param.containsKey("category"))
            return new ResponseEntity<>(recipeService.findRecipeByCategory(param.get("category")), HttpStatus.OK);

        if (param.size() == 1 && param.containsKey("name"))
            return new ResponseEntity<>(recipeService.findRecipeByName(param.get("name")), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable @Min(1) long id) {
        Optional<Recipe> recipe = recipeService.findRecipeById(id);
        if (recipe.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found for id = " + id);
        return new ResponseEntity<>(recipe.get(), HttpStatus.OK);
    }


    @PreAuthorize("isAuthenticated()")
    @PutMapping("{id}")
    public ResponseEntity<HttpStatus> updateRecipe(@PathVariable long id,
                                                   @Valid @RequestBody Recipe newRecipe,
                                                   Principal principal) {
        String creatorName = principal.getName();
        Optional<Recipe> oldRecipe = recipeService.findRecipeById(id);

        if (oldRecipe.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (!creatorName.equals(oldRecipe.get().getCreator())) return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        recipeService.updateRecipeById(id, newRecipe);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable @Min(1) long id, Principal principal) {
        String creatorName = principal.getName();

        Optional<Recipe> delRecipe = recipeService.findRecipeById(id);

        if (delRecipe.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (!creatorName.equals(delRecipe.get().getCreator())) return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        recipeService.deleteRecipeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
