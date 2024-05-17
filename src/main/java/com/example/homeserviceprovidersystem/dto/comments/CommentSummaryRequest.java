package com.example.homeserviceprovidersystem.dto.comments;

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
public class CommentSummaryRequest {
    @NotNull(message = "orderId is null")
    @Positive(message = "value orderId must be positive")
    Long orderId;
    @NotNull(message = "email cannot be null")
    @Email(message = "please enter an appropriate Email")
    String expertEmail;
}
