package com.company.singleresp_ex;

import java.time.Instant;

import com.company.singleresp_ex.controller.OrderController;
import com.company.singleresp_ex.entity.Order;

public class Main {

    private static final String TEST_JSON = "{\"orderId\": \"1\", \"value\": \"200.00\"}";
    
    public static void main(String[] args) {
        OrderController controller = new OrderController();
        controller.createOrder(TEST_JSON);
        
        Order order = controller.getOrder(1l);
        if(order.getLastUpdatedOn() != null && order.getLastUpdatedOn() > Instant.now().minusSeconds(10).getEpochSecond()) {
        	System.out.println("Test passed");
        } else {
        	System.err.println("Test Failed.");
        }
        
    }
}