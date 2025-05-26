package com.testing.order.service.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Order {
    @Id
    private String id;
    private String userId;       // from user-service
    private String productId;    // from product-service
    private int quantity;
    private double totalPrice;
    private String status;       // e.g., "PLACED", "SHIPPED", "CANCELLED"
    private LocalDateTime orderDate;
}
