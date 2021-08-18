package com.accenture.ws.controller;


import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.accenture.ws.entity.Order;
import static org.assertj.core.api.Assertions.*;

 

 

	@SpringBootTest
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	public class OrderAndBillingControllerTest {
		
    private static final Logger LOG = LoggerFactory.getLogger(OrderAndBillingControllerTest.class);

    @Autowired
    private OrderAndBillingController orderBillController;
    
    @Test
    @org.junit.jupiter.api.Order(1)
    public void getOrderListTest() throws Exception{
        List<Order> orderList = orderBillController.getOrderList();
        for (Order order : orderList) {
            order.setId(null);
        }
        
        assertThat(orderList).contains(new Order("Choco", 10.5, false),
                new Order("Tea", 4.5, false),
                new Order("Brew", 7, true));
    }
    
    @Test
    @org.junit.jupiter.api.Order(2)
    public void addOrderTest() throws Exception {
        Order addedOrder = new Order("Choco", 130.5, false);
        orderBillController.addOrder(addedOrder);
        
        List<Order> orderList = orderBillController.getOrderList();
        
        for (Order order : orderList) {
            order.setId(null);
        }
        
        assertThat(orderList).contains(new Order("Choco", 130.5, false));
    }
    
    @Test
    @org.junit.jupiter.api.Order(3)
    public void updateOrderTest() throws Exception {
        
    	Long id = 0L;
        
        List<Order> orderList = orderBillController.getOrderList();
        
        for (Order order : orderList) {
            id = order.getId();
            order.setId(id);
            
        if (order.equals(new Order(id, "Choco", 130.5, false, 5))) {
                break;
            }
        }
        
        Order updateOrder = new Order(id, "Choco", 135.0, true, 5);
        orderBillController.updateOrder(updateOrder);
        orderList = orderBillController.getOrderList();
        for (Order order : orderList) {
            order.setId(null);
        }
        assertThat(orderList).contains(new Order("Choco", 135.0, true));
    }
    
    @Test
    @org.junit.jupiter.api.Order(4)
    public void deleteOrderTest() throws Exception {
        Long id = 0L;
        
        List<Order> orderList = orderBillController.getOrderList();
        
        for (Order order : orderList) {
            id = order.getId();
            order.setId(id);
            
        if(order.equals(new Order("Choco", 130.5, true))) {
                break;
            }
        }
        
        orderBillController.deleteOrder(id);
        orderList = orderBillController.getOrderList();
        for(Order order : orderList) {
            order.setId(null);
        }
        
        assertThat(orderList).doesNotContain(new Order("Choco", 130.5, true));
    }
    
}