package com.example.homeserviceprovidersystem.service.impl;

import com.example.homeserviceprovidersystem.customeException.CustomBadRequestException;
import com.example.homeserviceprovidersystem.customeException.CustomEntityNotFoundException;
import com.example.homeserviceprovidersystem.customeException.CustomResourceNotFoundException;
import com.example.homeserviceprovidersystem.dto.expertsuggestion.ExpertSuggestionsRequest;
import com.example.homeserviceprovidersystem.dto.expertsuggestion.ExpertSuggestionsRequestWithId;
import com.example.homeserviceprovidersystem.dto.expertsuggestion.ExpertSuggestionsResponse;
import com.example.homeserviceprovidersystem.dto.expertsuggestion.ExpertSuggestionsSummaryRequest;
import com.example.homeserviceprovidersystem.entity.Customer;
import com.example.homeserviceprovidersystem.entity.Expert;
import com.example.homeserviceprovidersystem.entity.ExpertSuggestions;
import com.example.homeserviceprovidersystem.entity.Orders;
import com.example.homeserviceprovidersystem.entity.enums.OrderStatus;
import com.example.homeserviceprovidersystem.mapper.ExpertSuggestionsMapper;
import com.example.homeserviceprovidersystem.repositroy.ExpertSuggestionsRepository;
import com.example.homeserviceprovidersystem.repositroy.OrdersRepository;
import com.example.homeserviceprovidersystem.service.CustomerService;
import com.example.homeserviceprovidersystem.service.ExpertService;
import com.example.homeserviceprovidersystem.service.ExpertSuggestionsService;
import com.example.homeserviceprovidersystem.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExpertSuggestionsImpl implements ExpertSuggestionsService {
    private final ExpertService expertService;
    private final OrdersService ordersService;
    private final ExpertSuggestionsRepository expertSuggestionsRepository;
    private final OrdersRepository ordersRepository;
    private final CustomerService customerService;
    private final ExpertSuggestionsMapper expertSuggestionsMapper;

    @Autowired
    public ExpertSuggestionsImpl(
            ExpertService expertService,
            OrdersService ordersService,
            ExpertSuggestionsRepository expertSuggestionsRepository,
            OrdersRepository ordersRepository,
            CustomerService customerService,
            ExpertSuggestionsMapper expertSuggestionsMapper) {
        this.expertService = expertService;
        this.ordersService = ordersService;
        this.expertSuggestionsRepository = expertSuggestionsRepository;
        this.ordersRepository = ordersRepository;
        this.customerService = customerService;
        this.expertSuggestionsMapper = expertSuggestionsMapper;
    }

    @Override
    public ExpertSuggestionsResponse save(ExpertSuggestionsSummaryRequest request) {
        Expert expert = expertService.findByEmail(request.getExpertEmail());
        Orders orders = ordersService.findById(request.getOrderId());
        Optional<ExpertSuggestions> es = expertSuggestionsRepository.findByExpertEmailAndOrderId(expert.getEmail(), orders.getId());
        validateExpertSuggestions(expert, orders, request, es);
        ExpertSuggestions expertSuggestions = setExpertSuggestionsDetails(request, orders, expert);
        ExpertSuggestions saveExpertSuggestion = expertSuggestionsRepository.save(expertSuggestions);
        updateOrdersStatus(orders);
        return expertSuggestionsMapper.expertSuggestionToExpertSuggestionsResponse(saveExpertSuggestion);
    }

    private void validateExpertSuggestions(
            Expert expert,
            Orders orders,
            ExpertSuggestionsSummaryRequest expertSuggestionsSummaryRequest,
            Optional<ExpertSuggestions> es) {

        if (expert.getSubDuties().stream().noneMatch(subDuty -> orders.getSubDuty().getName().equals(subDuty.getName())) ||
                orders.getSubDuty().getBasePrice() > expertSuggestionsSummaryRequest.getProposedPrice()) {
            throw new CustomBadRequestException("Please select the order related to your specialty or " +
                    "Proposed price must be greater than or equal to the base price of the subDuty");
        }
        LocalDateTime orderTime = LocalDateTime.of(orders.getDateOfWork(), orders.getTimeOfWord());
        LocalDateTime expertSuggestionTime = LocalDateTime.of(expertSuggestionsSummaryRequest.getDateOfStartWork(), expertSuggestionsSummaryRequest.getTimeOfStartWork());
        if (expertSuggestionTime.isBefore(orderTime)) {
            throw new CustomBadRequestException("The start date and time must be on or after the order date and time");
        }
        if (es.isPresent()) {
            throw new CustomBadRequestException("You have already submitted an suggestion for this order");
        }
    }

    private ExpertSuggestions setExpertSuggestionsDetails(ExpertSuggestionsSummaryRequest request, Orders orders, Expert expert) {
        ExpertSuggestions suggestions = new ExpertSuggestions();
        suggestions.setProposedPrice(request.getProposedPrice());
        suggestions.setOfferDate(LocalDate.now());
        suggestions.setOfferTime(LocalTime.now());
        suggestions.setTimeOfStartWork(request.getTimeOfStartWork());
        suggestions.setDateOfStartWork(request.getDateOfStartWork());
        suggestions.setDurationOfWorkPerHour(request.getDurationOfWorkPerHour());
        suggestions.setOrders(orders);
        suggestions.setExpert(expert);
        return suggestions;
    }

    private void updateOrdersStatus(Orders orders) {
        orders.setOrderStatus(OrderStatus.ORDER_WAITING_FOR_SPECIALIST_SELECTION);
        ordersRepository.save(orders);
    }

    @Override
    public List<ExpertSuggestionsResponse> findAllOrderSuggestions(ExpertSuggestionsRequest request) {
        List<ExpertSuggestions> listOrderSuggestions =
                expertSuggestionsRepository.findAllOrderSuggestions(request.getCustomerEmail(), request.getSubDutyName(), OrderStatus.ORDER_WAITING_FOR_SPECIALIST_SELECTION);
        if (listOrderSuggestions.isEmpty()) {
            throw new CustomResourceNotFoundException("There is no result");
        } else {
            return listOrderSuggestions.stream()
                    .map(expertSuggestionsMapper::expertSuggestionToExpertSuggestionsResponse).toList();
        }
    }

    @Override
    public ExpertSuggestions findById(Long id) {
        return expertSuggestionsRepository.findById(id)
                .orElseThrow(() -> new CustomEntityNotFoundException("expertSuggestion with this id was not found"));
    }

    @Override
    public ExpertSuggestions findByExpertEmailAndOrderId(String expertEmail, Long orderId) {
        return expertSuggestionsRepository.findByExpertEmailAndOrderId(expertEmail, orderId)
                .orElseThrow(() -> new CustomEntityNotFoundException("No ExpertSuggestions found for this email"));
    }

    @Override
    public ExpertSuggestionsResponse selectExpertSuggestion(ExpertSuggestionsRequestWithId request) {
        Customer customer = customerService.findByEmail(request.getCustomerEmail());
        ExpertSuggestions expertSuggestion = findById(request.getExpertSuggestionId());
        Orders orders = expertSuggestion.getOrders();
        if (!orders.getCustomer().getId().equals(customer.getId())) {
            throw new CustomBadRequestException("expertSuggestion is not related to this customer");
        }
        if (orders.getOrderStatus().equals(OrderStatus.ORDER_WAITING_FOR_SPECIALIST_TO_WORKPLACE)) {
            throw new CustomBadRequestException("It is not possible to select this order");
        }
        orders.setOrderStatus(OrderStatus.ORDER_WAITING_FOR_SPECIALIST_TO_WORKPLACE);
        orders.setExpert(expertSuggestion.getExpert());
        ordersRepository.save(orders);
        return expertSuggestionsMapper.expertSuggestionToExpertSuggestionsResponse(expertSuggestion);
    }
}
