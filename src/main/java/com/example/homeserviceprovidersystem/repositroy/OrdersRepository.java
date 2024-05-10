package com.example.homeserviceprovidersystem.repositroy;

import com.example.homeserviceprovidersystem.entity.Orders;
import com.example.homeserviceprovidersystem.entity.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query("from Orders order where order.subDuty.name=:SUBDUTYNAME and (order.orderStatus =:SUGGESTION or order.orderStatus =:SELECTION)")
    List<Orders> findAllOrdersByOrderStatus(@Param("SUBDUTYNAME") String subDutyName, @Param("SUGGESTION") OrderStatus suggestion,
                                            @Param("SELECTION") OrderStatus selection);

    @Query("from Orders order where order.orderStatus=:ORDERSTATUS and order.customer.email =:CUSTOMEREMAIL")
    List<Orders> findAllByOrderStatusAndCustomerEmail(@Param("ORDERSTATUS") OrderStatus orderStatus, @Param("CUSTOMEREMAIL") String email);

    @Query("from Orders order where " +
            "order.subDuty.name=:SUBDUTYNAME and " +
            "order.customer.email=:CUSTOMEREMAIL and " +
            "order.ProposedPrice=:PROPOSEDPRICE and " +
            "order.jobDescription=:JOBDESCRIPTION and " +
            "order.dateOfWork=:DATEOFWORK and " +
            "order.TimeOfWord=:TIMEOFWORK and " +
            "order.address.province=:PROVINCE and " +
            "order.address.city=:CITY and " +
            "order.address.street=:STREET and " +
            "order.address.postalCode=:POSTALCODE and " +
            "order.orderStatus=:ORDERSTATUS")
    Optional<Orders> findByOrderInformation(
            @Param("SUBDUTYNAME") String subDutyName,
            @Param("CUSTOMEREMAIL") String customerEmail,
            @Param("PROPOSEDPRICE") double ProposedPrice,
            @Param("JOBDESCRIPTION") String jobDescription,
            @Param("DATEOFWORK") LocalDate dateOfWork,
            @Param("TIMEOFWORK") LocalTime TimeOfWord,
            @Param("PROVINCE") String province,
            @Param("CITY") String city,
            @Param("STREET") String street,
            @Param("POSTALCODE") String postalCode,
            @Param("ORDERSTATUS") OrderStatus orderStatus
    );
}
