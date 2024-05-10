package com.example.homeserviceprovidersystem.mapper;

import com.example.homeserviceprovidersystem.dto.expert.ExpertSummaryResponse;
import com.example.homeserviceprovidersystem.entity.Expert;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExpertMapper {
    ExpertSummaryResponse expertToExpertSummaryResponse(Expert expert);
}
