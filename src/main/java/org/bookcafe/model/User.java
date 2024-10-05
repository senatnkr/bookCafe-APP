package org.bookcafe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Otomatik artan ID

    @NotNull(message = "User name cannot be null")
    @Size(min = 2, max = 50, message = "User name must be between 2 and 50 characters")
    private String name; // Kullanıcı adı

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email; // Kullanıcı e-postası

    @NotNull(message = "Password cannot be null")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    private String role;

}
