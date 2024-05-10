package com.example.homeserviceprovidersystem.dto.expert;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ExpertRequestWithEmail {
    @NotNull(message = "email cannot be null")
    @Email(message = "please enter an appropriate Email")
    String email;
}
