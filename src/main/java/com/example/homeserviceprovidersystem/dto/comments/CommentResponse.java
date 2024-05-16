package com.example.homeserviceprovidersystem.dto.comments;

import com.example.homeserviceprovidersystem.base.BaseEntity;
import com.example.homeserviceprovidersystem.dto.address.AddressResponse;
import com.example.homeserviceprovidersystem.entity.Orders;
import com.example.homeserviceprovidersystem.entity.enums.OrderStatus;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class CommentResponse extends BaseEntity<Long> {
    int score;
    String comment;
    double proposedPrice;
    String jobDescription;
    LocalDate dateOfWork;
    LocalTime timeOfWord;
    AddressResponse address;
    OrderStatus orderStatus;
    String subDutyName;
}
