package recipes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Email
    @Pattern(regexp = ".+@.+\\..+", message = "Incorrect format email")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(min = 8, message = "password should contain at least 8 characters")
    @Column(name = "password")
    private String password;

    @JsonIgnore
    private String role;


//    @OneToMany(mappedBy = "user")
////    @JoinColumn(name = "user_id")
//    private List<Recipe> recipes = new ArrayList<>();
}
