package com.example.homeserviceprovidersystem.mapper;

import com.example.homeserviceprovidersystem.dto.order.OrdersResponse;
import com.example.homeserviceprovidersystem.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrdersMapper {
    @Mapping(source = "subDuty.name", target = "subDutyName")
    OrdersResponse orderToOrdersResponse(Orders order);
}
