package recipes.service;

import org.springframework.stereotype.Service;
import recipes.domain.Recipe;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RecipeService {

    private final Map<Integer, Recipe> recipes;
    private int idSequence;

    public RecipeService() {
        recipes = new ConcurrentHashMap<>();
        idSequence = 0;
    }

    public Optional<Recipe> findById(Integer id) {
        return Optional.of(recipes.get(id));
    }

    public Integer save(Recipe recipe) {
        int id = idSequence;
        recipes.put(id, recipe);
        incrementId();
        return id;
    }

    private void incrementId() {
        idSequence++;
    }
}