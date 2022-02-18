package task;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class Controller {
    final ConcurrentHashMap<Long, String> items = new ConcurrentHashMap<>(Map.of(
            55L, "Chair",
            99L, "Table",
            345L, "Vase"
    ));

    final String ERROR = "Item wasn't found";

    @GetMapping("/items/{id}")
    String getItem(@PathVariable long id) {
        String item = items.get(id);

        return item != null ? item : ERROR;
    }

    // Add your code below this line and do not change the code above the line.
    @DeleteMapping("/items/{id}")
    String deleteItem(@PathVariable long id) {
        String rItem = items.remove(id);

        return rItem != null ? rItem : ERROR;
    }

}
