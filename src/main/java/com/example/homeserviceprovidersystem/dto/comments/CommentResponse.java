package com.example.homeserviceprovidersystem.dto.comments;

import com.example.homeserviceprovidersystem.base.BaseEntity;
import com.example.homeserviceprovidersystem.entity.Orders;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class CommentResponse extends BaseEntity<Long> {
    int score;
    String comment;
    @OneToOne
    Orders orders;
}
