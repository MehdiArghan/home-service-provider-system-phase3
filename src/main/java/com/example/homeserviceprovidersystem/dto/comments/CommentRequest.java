package com.example.homeserviceprovidersystem.dto.comments;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class CommentRequest {
    @NotNull(message = "orderId is null")
    @Positive(message = "value orderId must be positive")
    Long orderId;
    @NotBlank(message = "please enter the appropriate customerEmail")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "dutyName must contain only letters")
    String customerEmail;
    @NotNull(message = "score is null")
    @Positive(message = "value score must be positive")
    int score;
    @NotBlank(message = "please enter the appropriate comment")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "dutyName must contain only letters")
    String comment;
}
