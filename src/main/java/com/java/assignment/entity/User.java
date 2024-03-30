package com.java.assignment.entity;

import com.java.assignment.util.UserType;
public class User {
    private final UserType userType;
    private final boolean isCustomerOver2Years;
    public User(UserType userType, boolean isCustomerOver2Years) {
        this.userType = userType;
        this.isCustomerOver2Years = isCustomerOver2Years;
    }
    public UserType getUserType() {
        return userType;
    }
    public boolean isCustomerOver2Years() {
        return isCustomerOver2Years;
    }
}



