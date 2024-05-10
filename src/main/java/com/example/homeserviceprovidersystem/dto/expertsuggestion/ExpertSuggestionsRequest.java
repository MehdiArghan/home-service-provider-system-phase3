package com.example.homeserviceprovidersystem.dto.expertsuggestion;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ExpertSuggestionsRequest {
    @NotBlank(message = "please enter an appropriate nameSubDuty")
    @Pattern(regexp = "[a-zA-Z]+", message = "subDutyName must contain only letters")
    String subDutyName;
    @NotNull(message = "email cannot be null")
    @Email(message = "please enter an appropriate Email")
    String customerEmail;
}
