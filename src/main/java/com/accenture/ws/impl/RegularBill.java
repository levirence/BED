package com.accenture.ws.impl;

import java.util.List;

import com.accenture.ws.entity.CafeClark;
import com.accenture.ws.entity.Order;


public class RegularBill extends OrderBill {

	public RegularBill(CafeClark clerk) {
		super(clerk);
	}
	
	@Override
	public double getTotalBill() {
		List<Order> orderList = getOrderList();
		
		if (orderList.size() > 0) {
			double totalAmount = 0;
			for (int i = 0; i < orderList.size(); i++) {
				totalAmount = totalAmount + orderList.get(i).getPrice();
			}
			return totalAmount;
		} else {
			return 0;
		}
	}

	
}
