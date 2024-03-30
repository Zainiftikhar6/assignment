package com.java.assignment.service;

import com.java.assignment.entity.User;
import com.java.assignment.entity.OrderItem;
import com.java.assignment.util.UserType;

import java.util.List;
public class BillingServiceImpl implements BillingService {
    @Override
    public double calculateNetPayableAmount(User user, List<OrderItem> orderItems) {
        double totalBillAmount = calculateTotalBillAmount(orderItems);
        double percentageDiscount = calculatePercentageDiscount(user, orderItems);

        return calculateTotalDiscount(totalBillAmount, percentageDiscount);
    }
    private double calculateTotalBillAmount(List<OrderItem> orderItems) {
        return orderItems.stream().mapToDouble(OrderItem::getBill).sum();
    }
    private double calculateTotalDiscount(double totalBillAmount, double percentageDiscount) {
        double billAmountDiscount = totalBillAmount - percentageDiscount;
        return billAmountDiscount - Math.floor(billAmountDiscount / 100) * 5;
    }
    private double calculatePercentageDiscount(User user, List<OrderItem> orderItems) {

        double percentageDiscount = 0;
        if (user.getUserType() == UserType.EMPLOYEE) {
            percentageDiscount = orderItems.stream()
                    .mapToDouble(item -> item.isGrocery() ? 0 : item.getBill() * 0.3)
                    .sum();
        } else if (user.getUserType() == UserType.AFFILIATE) {
            percentageDiscount = orderItems.stream()
                    .mapToDouble(item -> item.isGrocery() ? 0 : item.getBill() * 0.1)
                    .sum();
        } else if (user.getUserType() == UserType.CUSTOMER && user.isCustomerOver2Years()) {
            percentageDiscount = orderItems.stream()
                    .mapToDouble(item -> item.isGrocery() ? 0 : item.getBill() * 0.05 )
                    .sum();
        }
        return percentageDiscount;
    }
}