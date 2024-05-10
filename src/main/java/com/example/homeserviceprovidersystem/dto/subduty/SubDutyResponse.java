package com.example.homeserviceprovidersystem.dto.subduty;

import com.example.homeserviceprovidersystem.base.BaseEntity;
import com.example.homeserviceprovidersystem.entity.Duty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubDutyResponse extends BaseEntity<Long> {
    String name;
    double basePrice;
    String description;
    Duty duty;
}
