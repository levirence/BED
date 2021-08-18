package com.accenture.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ws.repository.OrderRepository;


import com.accenture.ws.entity.CafeClark;
import com.accenture.ws.entity.Order;
import com.accenture.ws.impl.DiscountedBill;
import com.accenture.ws.impl.OrderBill;
import com.accenture.ws.impl.RegularBill;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("http://localhost:4200")
public class OrderAndBillingController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CafeClark clerk;
	
	public OrderAndBillingController(com.accenture.ws.entity.CafeClark clerk) {
		super();
		this.clerk = clerk;
	}

	
	@GetMapping("/order")
	public List<Order> getOrderList() {
		setTotalBill();
		return orderRepository.findAll();
	}
	
   
	@PostMapping("/add")
	public Order addOrder(@RequestBody Order order) {
		setTotalBill();
		return orderRepository.save(order);
	}
   
	@PutMapping("/update")
	public Order updateOrder (@RequestBody Order order) {
		setTotalBill();
		orderRepository.save(order);
		return order;
	}
   
	@DeleteMapping("/delete/{id}")
	public void deleteOrder (@PathVariable Long id) {
		
		if (id == null) {
			throw new RuntimeException("Cannot delete order with number of " + id);
		}
		
		orderRepository.deleteById(id);
		setTotalBill();
	}
    
	@GetMapping("/bills")
	public List<String> getBills() {
		setTotalBill();
		List<String> data = new ArrayList<>();
		data.add(clerk.getName());
		data.add(Double.toString(getTotalRegularBill().getTotalBill()));
		data.add(Double.toString(getTotalDiscountedBill().getTotalBill()));
		return data;
	}
    
    public OrderBill getTotalRegularBill() {
		return new RegularBill(clerk);
	}
    
    public OrderBill getTotalDiscountedBill() {
		return new DiscountedBill(clerk);
	}
    
    public void setTotalBill() {
		List<Order> orderList = orderRepository.findAll();
		getTotalRegularBill().setOrderList(orderList);
		getTotalDiscountedBill().setOrderList(orderList);
	}
	
}
