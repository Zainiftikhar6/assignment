package com.java.assignment.service;

import com.java.assignment.entity.User;
import com.java.assignment.entity.OrderItem;
import com.java.assignment.util.UserType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BillingServiceImplTest {

    @Test
    void testCalculateNetPayableAmount_Employee()
    {
        User user = mock(User.class);
        when(user.getUserType()).thenReturn(UserType.EMPLOYEE);

        OrderItem item1 = new OrderItem( 100, false);
        OrderItem item2 = new OrderItem( 200, true);
        List<OrderItem> orderItems = Arrays.asList(item1, item2);

        BillingServiceImpl billingServiceImpl = new BillingServiceImpl();
        double netPayableAmount = billingServiceImpl.calculateNetPayableAmount(user, orderItems);

        Assertions.assertEquals(260, netPayableAmount, 0.001);
    }
    @Test
    public void testCalculateNetPayableAmount_Affiliate() {
        User user = mock(User.class);
        when(user.getUserType()).thenReturn(UserType.AFFILIATE);

        OrderItem item1 = new OrderItem( 500, false);
        OrderItem item2 = new OrderItem( 200, true);
        List<OrderItem> orderItems = Arrays.asList(item1, item2);

        BillingServiceImpl billingServiceImpl = new BillingServiceImpl();
        double netPayableAmount = billingServiceImpl.calculateNetPayableAmount(user, orderItems);

        Assertions.assertEquals(620, netPayableAmount, 0.001);
    }

    @Test
    public void testCalculateNetPayableAmount_CustomerOverTwoYears() {
        User user = mock(User.class);
        when(user.getUserType()).thenReturn(UserType.CUSTOMER);
        when(user.isCustomerOver2Years()).thenReturn(true);

        OrderItem item1 = new OrderItem( 500, false);
        OrderItem item2 = new OrderItem(200, true);
        List<OrderItem> orderItems = Arrays.asList(item1, item2);

        BillingServiceImpl billingServiceImpl = new BillingServiceImpl();
        double netPayableAmount = billingServiceImpl.calculateNetPayableAmount(user, orderItems);

        Assertions.assertEquals(645, netPayableAmount, 0.001);
    }
    @Test
    public void testCalculateNetPayableAmount_CustomerBelowTwoYears() {
        User user = mock(User.class);
        when(user.getUserType()).thenReturn(UserType.CUSTOMER);
        when(user.isCustomerOver2Years()).thenReturn(false);

        OrderItem item1 = new OrderItem( 500, false);
        OrderItem item2 = new OrderItem(200, true);
        List<OrderItem> orderItems = Arrays.asList(item1, item2);

        BillingServiceImpl billingServiceImpl = new BillingServiceImpl();
        double netPayableAmount = billingServiceImpl.calculateNetPayableAmount(user, orderItems);

        Assertions.assertEquals(665, netPayableAmount, 0.001);
    }
}