package task;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @PostMapping("/test")
    String postSome(@RequestParam String param){
        return param;
    }

    /*@PostMapping("/movies/{movieId}/comments")
    public void comment(@PathVariable String movieId, @RequestBody String comment);

    POST /movies/5196724/comments*/

}
