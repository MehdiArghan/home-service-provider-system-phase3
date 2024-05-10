package com.example.homeserviceprovidersystem.dto.expertsuggestion;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ExpertSuggestionsRequestWithId {
    @NotNull(message = "value is null")
    @Positive(message = "value proposedPrice must be positive")
    Long expertSuggestionId;
    @NotNull(message = "email cannot be null")
    @Email(message = "please enter an appropriate Email")
    String customerEmail;
}
