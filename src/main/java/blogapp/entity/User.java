package blogapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="user_name", nullable=false, length = 100)
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="pasword")
    private String password;
    @Column(name="about")
    private String about;
}
