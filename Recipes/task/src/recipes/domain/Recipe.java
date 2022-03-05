package recipes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "table_recipes")
public class Recipe {

    public Recipe(String name, String category, LocalDateTime time, String description, List<String> ingredients, List<String> directions) {
        this.name = name;
        this.category = category;
        this.time = time;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipe_id")
    @JsonIgnore
    private Long id;

    @NotBlank
    @NotEmpty(message = "Name is required field")
    @Column(name = "name")
    private String name;

    @NotBlank
    @NotEmpty(message = "Category is required field")
    @Column(name = "category")
    private String category;

    @JsonIgnore
    @Column(name = "date")
    private LocalDateTime time;

    @NotEmpty
    @NotBlank
    @Column(name = "description")
    private String description;

    @NotEmpty
    @Size(min = 1)
    @ElementCollection
    @CollectionTable(name = "table_ingredients", joinColumns = @JoinColumn(name = "ingredient_id"))
    @Column(name = "ingredients")
    private List<String> ingredients;

    @NotEmpty
    @Size(min = 1)
    @ElementCollection
    @CollectionTable(name = "table_directions", joinColumns = @JoinColumn(name = "direction_id"))
    @Column(name = "directions")
    private List<String> directions;

}
