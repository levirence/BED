package com.accenture.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_record")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="order_name")
	private String orderName;
	
	@Column(name="price")
	private double price;
	
	@Column(name= "is_discounted")
	private boolean isDiscounted;
	
	@Column(name="is_discounted_percentage")
	private double isDiscountedPercentage = 5.0;
	
	
	public Order() {
				
	}
	
	public Order(String orderName, double price, boolean isDiscounted) {
		super();
		this.orderName = orderName;
		this.price = price;
		this.isDiscounted = isDiscounted;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getOrderName() {
		return orderName;
	}


	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public boolean isDiscounted() {
		return isDiscounted;
	}


	public void setDiscounted(boolean isDiscounted) {
		this.isDiscounted = isDiscounted;
	}


	public double getIsDiscountedPercentage() {
		return isDiscountedPercentage;
	}


	public void setIsDiscountedPercentage(double isDiscountedPercentage) {
		this.isDiscountedPercentage = isDiscountedPercentage;
	}

	public Order(Long id, String orderName, double price, boolean isDiscounted, double isDiscountedPercentage) {
		super();
		this.id = id;
		this.orderName = orderName;
		this.price = price;
		this.isDiscounted = isDiscounted;
		this.isDiscountedPercentage = isDiscountedPercentage;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderName=" + orderName + ", price=" + price + ", isDiscounted=" + isDiscounted
				+ ", isDiscountedPercentage=" + isDiscountedPercentage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isDiscounted ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(isDiscountedPercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((orderName == null) ? 0 : orderName.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isDiscounted != other.isDiscounted)
			return false;
		if (Double.doubleToLongBits(isDiscountedPercentage) != Double.doubleToLongBits(other.isDiscountedPercentage))
			return false;
		if (orderName == null) {
			if (other.orderName != null)
				return false;
		} else if (!orderName.equals(other.orderName))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	

}
