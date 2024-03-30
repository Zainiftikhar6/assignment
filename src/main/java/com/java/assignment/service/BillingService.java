package com.java.assignment.service;

import com.java.assignment.entity.User;
import com.java.assignment.entity.OrderItem;

import java.util.List;

public interface BillingService {
     double calculateNetPayableAmount(User user, List<OrderItem> orderItems);
}
