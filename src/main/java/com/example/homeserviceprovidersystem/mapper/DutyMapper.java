package com.example.homeserviceprovidersystem.mapper;

import com.example.homeserviceprovidersystem.dto.duty.DutyRequest;
import com.example.homeserviceprovidersystem.dto.duty.DutyResponse;
import com.example.homeserviceprovidersystem.entity.Duty;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DutyMapper {
    Duty dutyRequestToDuty(DutyRequest dutyRequest);

    DutyResponse dutyToDutyResponse(Duty duty);
}
