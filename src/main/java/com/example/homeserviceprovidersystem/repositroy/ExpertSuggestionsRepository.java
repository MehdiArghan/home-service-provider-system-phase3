package com.example.homeserviceprovidersystem.repositroy;

import com.example.homeserviceprovidersystem.entity.ExpertSuggestions;
import com.example.homeserviceprovidersystem.entity.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpertSuggestionsRepository extends JpaRepository<ExpertSuggestions, Long> {
    @Query("from ExpertSuggestions es where" +
            " es.orders.customer.email =:CUSTOMEREMAIL and" +
            " es.orders.subDuty.name =:SUBDUTYNAME and" +
            " es.orders.orderStatus =:SELECTION" +
            " order by es.ProposedPrice asc")
    List<ExpertSuggestions> findAllOrderSuggestions(
            @Param("CUSTOMEREMAIL") String customerEmail,
            @Param("SUBDUTYNAME") String subDutyName,
            @Param("SELECTION") OrderStatus orderStatus);

    @Query("from ExpertSuggestions es where es.expert.email=:EXPERTEMAIL and es.orders.id=:ORDERSID")
    Optional<ExpertSuggestions> findByExpertEmailAndOrderId(
            @Param("EXPERTEMAIL") String expertEmail,
            @Param("ORDERSID") Long ordersId);
}
