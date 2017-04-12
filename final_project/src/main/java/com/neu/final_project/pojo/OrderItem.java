package com.neu.final_project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderItem")
public class OrderItem {

	private int orderItemId;
	private Food food;
	private int quantity;
	private Order order;
	
	public OrderItem() {
		food = new Food();
		order = new Order();
	}
	
	@Id
	@Column(name="ORDER_ITEM_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getOrderItemId() {
		return orderItemId;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FOOD_ID", nullable = false)
	public Food getFood() {
		return food;
	}
	
	@Column(name="QUANTITY")
	public int getQuantity() {
		return quantity;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORDER_ID", nullable = false)
	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}