package blogapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    @NotEmpty(message = "Name can't be empty")
    private String name;
    @Email(message = "Email is not valid")
    private String email;
    @Size(min = 6, max = 10, message = "Password must be min of 6 and max of 10 character long")
    private String password;
    @Size(min = 10, max = 50)
    private String about;
}

