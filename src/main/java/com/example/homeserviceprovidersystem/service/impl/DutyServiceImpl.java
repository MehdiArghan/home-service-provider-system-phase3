package com.example.homeserviceprovidersystem.service.impl;

import com.example.homeserviceprovidersystem.customeException.CustomBadRequestException;
import com.example.homeserviceprovidersystem.customeException.CustomEntityNotFoundException;
import com.example.homeserviceprovidersystem.customeException.CustomResourceNotFoundException;
import com.example.homeserviceprovidersystem.dto.duty.DutyRequest;
import com.example.homeserviceprovidersystem.dto.duty.DutyResponse;
import com.example.homeserviceprovidersystem.entity.Duty;
import com.example.homeserviceprovidersystem.mapper.DutyMapper;
import com.example.homeserviceprovidersystem.repositroy.DutyRepository;
import com.example.homeserviceprovidersystem.service.DutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DutyServiceImpl implements DutyService {
    private final DutyRepository dutyRepository;
    private final DutyMapper dutyMapper;

    @Autowired
    public DutyServiceImpl(DutyRepository dutyRepository, DutyMapper dutyMapper) {
        this.dutyRepository = dutyRepository;
        this.dutyMapper = dutyMapper;
    }

    @Override
    public DutyResponse save(DutyRequest dutyRequest) {
        Optional<Duty> foundDuty = dutyRepository.findByName(dutyRequest.getName());
        if (foundDuty.isEmpty()) {
            Duty duty = dutyMapper.dutyRequestToDuty(dutyRequest);
            return dutyMapper.dutyToDutyResponse(dutyRepository.save(duty));
        } else {
            throw new CustomBadRequestException("Duty with name '" + dutyRequest.getName() + "'available");
        }
    }

    @Override
    public Duty findByName(String nameDuty) {
        Optional<Duty> findDuty = dutyRepository.findByName(nameDuty);
        if (findDuty.isEmpty()) {
            throw new CustomEntityNotFoundException("No duty found with the given name");
        } else {
            return findDuty.get();
        }
    }

    @Override
    public List<DutyResponse> findAll() {
        List<Duty> dutyList = dutyRepository.findAll();
        if (dutyList.isEmpty()) {
            throw new CustomResourceNotFoundException("There is no result");
        } else {
            return dutyList.stream().map(dutyMapper::dutyToDutyResponse).toList();
        }
    }
}
