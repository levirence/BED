package com.accenture.ws.impl;

import java.util.List;

import com.accenture.ws.entity.CafeClark;
import com.accenture.ws.entity.Order;

public abstract class OrderBill {
	
	private static List<Order> orderList;
	
	private CafeClark clerk;

	public OrderBill(CafeClark clerk) {
		this.clerk = clerk;
	}


	public List<Order> getOrderList() {
		return orderList;
	}


	public void setOrderList(List<Order> orderList) {
		OrderBill.orderList = orderList;
	}


	public CafeClark getClerk() {
		return clerk;
	}


	public abstract double getTotalBill();
	
//	public double getTotalBill() {
//		List<Order> orderList = getOrderList();
//		
//		if(orderList.size() > 0) {
//			double totalAmount = 0;
//			
//			int i = 0;
//			for(i = 0; i < orderList.size(); i++) {
//				totalAmount += orderList.get(i).getPrice();
//			}
//			return totalAmount;
//		}
//		return 0;
//	}
//	
	
}
