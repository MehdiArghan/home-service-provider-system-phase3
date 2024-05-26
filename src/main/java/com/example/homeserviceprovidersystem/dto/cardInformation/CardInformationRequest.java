package com.example.homeserviceprovidersystem.dto.cardInformation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardInformationRequest {
    @NotBlank(message = "Please enter the correct cardNumber")
    @Pattern(regexp = "^\\d{4}$", message = "Please enter the four digits of the card correctly")
    String cardNumber1;
    @NotBlank(message = "Please enter the correct cardNumber")
    @Pattern(regexp = "^\\d{4}$", message = "Please enter the four digits of the card correctly")
    String cardNumber2;
    @NotBlank(message = "Please enter the correct cardNumber")
    @Pattern(regexp = "^\\d{4}$", message = "Please enter the four digits of the card correctly")
    String cardNumber3;
    @NotBlank(message = "Please enter the correct cardNumber")
    @Pattern(regexp = "^\\d{4}$", message = "Please enter the four digits of the card correctly")
    String cardNumber4;
    @NotBlank(message = "Please enter the correct cvv2")
    @Pattern(regexp = "^\\d{4}$", message = "Please enter the four digits of the cvv2 correctly")
    String cvv2;
    @NotBlank(message = "Please enter the correct Year")
    @Pattern(regexp = "^\\d{2}$", message = "Please enter the two digits of the Year correctly")
    String year;
    @NotBlank(message = "Please enter the correct month")
    @Pattern(regexp = "^\\d{2}$", message = "Please enter the two digits of the month correctly")
    String month;
    @NotBlank(message = "Please enter the deposit amount correctly")
    @Pattern(regexp = "^(?!0*(\\.0+)?$)(\\d+(\\.\\d{1,2})?)$", message = "Please enter a valid deposit amount")
    String amount;
    @NotBlank(message = "Please enter the correct captcha text")
    String captcha;
}
