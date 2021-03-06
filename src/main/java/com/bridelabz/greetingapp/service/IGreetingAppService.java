package com.bridelabz.greetingapp.service;

import java.util.List;

import com.bridelabz.greetingapp.model.GreetingApp;

public interface IGreetingAppService {
		List<GreetingApp> getGreeting();
		public GreetingApp getGreetingById(Long id);
		public GreetingApp putGreeting(String message, long id);
		public GreetingApp postGreeting(String name);
		public GreetingApp deleteGreeting(long id);
}
