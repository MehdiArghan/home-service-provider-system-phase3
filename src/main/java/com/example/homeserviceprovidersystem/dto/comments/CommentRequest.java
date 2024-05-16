package com.example.homeserviceprovidersystem.dto.comments;

import jakarta.validation.constraints.*;
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
    @NotNull(message = "email cannot be null")
    @Email(message = "please enter an appropriate Email")
    String customerEmail;
    @NotNull(message = "score is null")
    @Positive(message = "value score must be positive")
    int score;
    @NotBlank(message = "please enter the appropriate comment")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "comment must contain only letters")
    String comment;
}
