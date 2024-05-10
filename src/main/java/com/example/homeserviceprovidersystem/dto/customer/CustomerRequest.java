package com.example.homeserviceprovidersystem.dto.customer;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class CustomerRequest {
    @NotNull(message = "firstName cannot be null")
    @NotEmpty(message = "firstName cannot be empty")
    @Column(nullable = false)
    @Pattern(regexp = "[a-zA-Z]+", message = "firstName must contain only letters")
    String firstName;
    @NotNull(message = "lastName cannot be null")
    @NotEmpty(message = "lastName cannot be empty")
    @Column(nullable = false)
    @Pattern(regexp = "[a-zA-Z]+", message = "lastName must contain only letters")
    String lastName;
    @NotNull(message = "email cannot be null")
    @Email(message = "please enter an appropriate Email")
    @Column(unique = true)
    String email;
    @NotBlank(message = "please enter an appropriate password")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$",
            message = "Password must be at least 8 characters long and contain at least one letter and one number")
    String password;
}
