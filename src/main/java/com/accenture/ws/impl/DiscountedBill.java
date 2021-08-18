package com.accenture.ws.impl;

import java.util.List;



import com.accenture.ws.entity.CafeClark;
import com.accenture.ws.entity.Order;


public class DiscountedBill extends OrderBill {
	
	public static final double PERCENTAGE = 100.0;
	
	public DiscountedBill(CafeClark clerk) {
		super(clerk);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getTotalBill() {
		List<Order> orderList = getOrderList();
		
		if (orderList.size() > 0) {
			double totalAmount = 0;
			for (int i = 0; i < orderList.size(); i++) {
				if (orderList.get(i).isDiscounted()) {
					totalAmount += orderList.get(i).getPrice() - 
							(orderList.get(i).getPrice() 
									* (orderList.get(i)
									.getIsDiscountedPercentage() / PERCENTAGE));
				} else {
					totalAmount += orderList.get(i).getPrice();
				}
			}
			double finalAmount = Math.round(totalAmount * PERCENTAGE) / PERCENTAGE;
			return finalAmount;
		} else {
			return 0;
		}
		
	}
	
}
