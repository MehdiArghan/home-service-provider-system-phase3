package com.example.homeserviceprovidersystem.service.impl;

import com.example.homeserviceprovidersystem.customeException.CustomBadRequestException;
import com.example.homeserviceprovidersystem.dto.comments.CommentRequest;
import com.example.homeserviceprovidersystem.dto.comments.CommentResponse;
import com.example.homeserviceprovidersystem.entity.Comments;
import com.example.homeserviceprovidersystem.entity.Orders;
import com.example.homeserviceprovidersystem.entity.enums.OrderStatus;
import com.example.homeserviceprovidersystem.mapper.CommentsMapper;
import com.example.homeserviceprovidersystem.repositroy.CommentsRepository;
import com.example.homeserviceprovidersystem.service.CommentsService;
import com.example.homeserviceprovidersystem.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentsService {
    private final OrdersService ordersService;
    private final CommentsRepository commentsRepository;
    private final CommentsMapper commentsMapper;

    @Autowired
    public CommentServiceImpl(OrdersService ordersService, CommentsRepository commentsRepository, CommentsMapper commentsMapper) {
        this.ordersService = ordersService;
        this.commentsRepository = commentsRepository;
        this.commentsMapper = commentsMapper;
    }

    @Override
    public CommentResponse save(CommentRequest request) {
        Orders order = ordersService.findById(request.getOrderId());
        if (!order.getOrderStatus().equals(OrderStatus.ORDER_PAID) ||
                !order.getCustomer().getEmail().equals(request.getCustomerEmail())) {
            throw new CustomBadRequestException("Order not found");
        }
        if (request.getScore() < 1 || request.getScore() > 5) {
            throw new CustomBadRequestException("The score must be between 1 and 5");
        }
        Optional<Comments> foundComment = commentsRepository.findByOrderId(order.getId());
        if (foundComment.isPresent()) {
            throw new CustomBadRequestException("There is a comment for this order");
        }
        Comments comments = new Comments();
        comments.setScore(request.getScore());
        comments.setComment(request.getComment());
        comments.setOrders(order);
        return commentsMapper.commentsToCommentResponse(commentsRepository.save(comments));
    }
}
