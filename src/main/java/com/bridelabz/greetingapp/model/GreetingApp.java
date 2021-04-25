package com.bridelabz.greetingapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GreetingApp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String message;
	public GreetingApp() {}

	public GreetingApp(String message, long id) {
		super();
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
