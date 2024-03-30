package com.java.assignment.entity;

public class OrderItem {
    private final double bill;
    private final boolean isGrocery;
    public OrderItem(double bill, boolean isGrocery) {
        this.bill = bill;
        this.isGrocery = isGrocery;
    }
    public double getBill() {
        return bill;
    }

    public boolean isGrocery() {
        return isGrocery;
    }
}