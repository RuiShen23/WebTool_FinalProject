package com.neu.final_project.pojo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Post {
	
	private int postId;
	private User postUser; //Ë«Ïò£¬1-m
	private String postTitle;
	private String postContent;
	private String attachmentPath;
	private MultipartFile attachment;
	private Date sendDate;
	
}
