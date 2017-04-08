package com.neu.final_project.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Message {

	private int messageId;
	private User fromUserId;
	private Employee toEmployeeId;
	private String messageTitle;
	private String messageContent;
	private Date sendDate;
	
	public Message(){
		
	}
}
