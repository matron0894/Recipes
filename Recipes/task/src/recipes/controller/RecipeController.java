package recipes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.service.IdGenerator;
import recipes.domain.Recipe;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private static Map<Integer, Recipe> recipes = new ConcurrentHashMap<>();
    private static IdGenerator idGen = new IdGenerator();

    @PostMapping("/new")
    public IdGenerator saveRecipe(@RequestBody Recipe recipe) {
        recipes.put(idGen.nextId(), recipe);
        return idGen;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable int id) {
        if (!recipes.containsKey(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(recipes.get(id), HttpStatus.OK);
    }
}
