package com.example.homeserviceprovidersystem.dto.order;

import com.example.homeserviceprovidersystem.dto.address.AddressRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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
public class OrderSummaryRequest {
    @NotBlank(message = "please enter an appropriate nameSubDuty")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "subDutyName must contain only letters")
    String subDutyName;
    @NotNull(message = "email cannot be null")
    @Email(message = "please enter an appropriate Email")
    String customerEmail;
    @NotNull(message = "value is null")
    @Positive(message = "value proposedPrice must be positive")
    double ProposedPrice;
    @NotBlank(message = "please write a suitable description for the job")
    String jobDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please enter the appropriate date")
    LocalDate dateOfWork;
    @DateTimeFormat(pattern = "HH:mm:ss")
    @NotNull(message = "Please enter an appropriate time")
    LocalTime TimeOfWord;
    @Valid
    AddressRequest address;
}
