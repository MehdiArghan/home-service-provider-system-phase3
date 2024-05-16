package com.example.homeserviceprovidersystem.dto.comments;

import com.example.homeserviceprovidersystem.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class CommentSummaryResponse extends BaseEntity<Long> {
    int score;
}
