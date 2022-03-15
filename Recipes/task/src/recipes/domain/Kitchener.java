package recipes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Entity
@NoArgsConstructor
@Table(name = "table_users")
public class Kitchener {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Email
    @Pattern(regexp = ".+@.+\\..+")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank
    @Min(value = 8)
    @Column(name = "pass")
    private String password;
}
