package recipes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

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

    public Recipe(String name, String category, String description, List<String> ingredients, List<String> directions) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipe_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "name can not blank")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "category can not blank")
    @Column(name = "category")
    private String category;


    @Column(name = "date")
    @UpdateTimestamp
    private LocalDateTime date;

    @NotBlank(message = "description can not blank")
    @Column(name = "description")
    private String description;

    @NotEmpty(message = "ingredients can not empty")
    @Size(min = 1, message = "ingredients must >= 1")
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "table_ingredients", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "ingredients")
    private List<String> ingredients;


    @NotEmpty(message = "directions can not empty")
    @Size(min = 1, message = "directions must >= 1")
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "table_directions", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "directions")
    private List<String> directions;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;
}
