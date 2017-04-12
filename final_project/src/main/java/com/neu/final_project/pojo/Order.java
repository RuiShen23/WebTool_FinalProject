package com.neu.final_project.pojo;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="order_table")
public class Order {

	private int orderId;
	private Set<OrderItem> orderItems;
	private User user;
	private Date placeDate;
	
	public Order(){
		orderItems = new HashSet<OrderItem>();
		user = new User();
	}
	
	
	@Id
	@Column(name="ORDER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getOrderId() {
		return orderId;
	}
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="order")
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable = false)
	public User getUser() {
		return user;
	}

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PLACE_DATE")
	public Date getPlaceDate() {
		return placeDate;
	}
	
	
	
}
