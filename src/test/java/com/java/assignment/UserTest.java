package com.java.assignment;

import com.java.assignment.entity.User;
import com.java.assignment.util.UserType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getUserType() {
        User user = new User(UserType.CUSTOMER,true);
        Assertions.assertEquals(user.getUserType(), (UserType.CUSTOMER));
    }

    @Test
    void isCustomerOver2Years() {
        User user = new User(UserType.CUSTOMER,true);
        assertTrue(user.isCustomerOver2Years());
    }
}