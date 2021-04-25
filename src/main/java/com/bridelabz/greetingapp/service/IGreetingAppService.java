package com.bridelabz.greetingapp.service;

import java.util.List;

import com.bridelabz.greetingapp.model.GreetingApp;

public interface IGreetingAppService {

		List<GreetingApp> getGreeting();
		GreetingApp getGreetingById(Long id);
		GreetingApp putGreeting(String greetingMessage, Long id);
		GreetingApp postGreeting(String name);
		GreetingApp deleteGreeting(Long id);
}
