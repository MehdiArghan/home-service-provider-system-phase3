package com.example.homeserviceprovidersystem.mapper;

import com.example.homeserviceprovidersystem.dto.subduty.SubDutyResponse;
import com.example.homeserviceprovidersystem.entity.SubDuty;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubDutyMapper {
    SubDutyResponse subDutyToSubDutyResponse(SubDuty subDuty);
}