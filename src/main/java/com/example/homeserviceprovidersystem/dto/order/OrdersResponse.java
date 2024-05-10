package com.example.homeserviceprovidersystem.dto.order;

import com.example.homeserviceprovidersystem.base.BaseEntity;
import com.example.homeserviceprovidersystem.dto.address.AddressResponse;
import com.example.homeserviceprovidersystem.entity.enums.OrderStatus;
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
public class OrdersResponse extends BaseEntity<Long> {
    double ProposedPrice;
    String jobDescription;
    LocalDate dateOfWork;
    LocalTime TimeOfWord;
    AddressResponse address;
    OrderStatus orderStatus;
    String subDutyName;
}
