package com.bridelabz.greetingapp.model;

public class GreetingApp {
	private String message;
	private long id;
	
	public GreetingApp(String message, long id) {
		this.message = message;
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public long getId() {
		return id;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
