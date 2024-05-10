package com.example.homeserviceprovidersystem.dto.expertsuggestion;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ExpertSuggestionsSummaryRequest {
    @NotNull(message = "value is null")
    @Positive(message = "value proposedPrice must be positive")
    Long orderId;
    @NotNull(message = "email cannot be null")
    @Email(message = "please enter an appropriate Email")
    String expertEmail;
    @NotNull(message = "value is null")
    @Positive(message = "value proposedPrice must be positive")
    double ProposedPrice;
    @FutureOrPresent(message = "Date must be in the present or future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please enter the appropriate date")
    LocalDate DateOfStartWork;
    @FutureOrPresent(message = "time must be in the present or future")
    @DateTimeFormat(pattern = "HH:mm:ss")
    @NotNull(message = "Please enter an appropriate time")
    LocalTime TimeOfStartWork;
    @NotNull(message = "value is null")
    @Positive(message = "value proposedPrice must be positive")
    Integer durationOfWorkPerHour;
}
