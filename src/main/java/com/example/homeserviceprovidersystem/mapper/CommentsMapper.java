package com.example.homeserviceprovidersystem.mapper;

import com.example.homeserviceprovidersystem.dto.comments.CommentResponse;
import com.example.homeserviceprovidersystem.dto.comments.CommentSummaryResponse;
import com.example.homeserviceprovidersystem.entity.Comments;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentsMapper {
    @Mapping(source = "orders.proposedPrice", target = "proposedPrice")
    @Mapping(source = "orders.jobDescription", target = "jobDescription")
    @Mapping(source = "orders.dateOfWork", target = "dateOfWork")
    @Mapping(source = "orders.timeOfWord", target = "timeOfWord")
    @Mapping(source = "orders.address", target = "address")
    @Mapping(source = "orders.orderStatus", target = "orderStatus")
    @Mapping(source = "orders.subDuty.name", target = "subDutyName")
    CommentResponse commentsToCommentResponse(Comments comments);

    CommentSummaryResponse commentsToCommentSummaryResponse(Comments comments);
}
