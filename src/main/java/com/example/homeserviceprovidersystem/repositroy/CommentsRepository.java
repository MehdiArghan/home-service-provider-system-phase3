package com.example.homeserviceprovidersystem.repositroy;

import com.example.homeserviceprovidersystem.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
    @Query("from Comments comment where comment.orders.id=:ORDERID")
     Optional<Comments> findByOrderId(@Param("ORDERID") Long orderId);
}
