package com.bridelabz.greetingapp.service;

import com.bridelabz.greetingapp.model.GreetingApp;

public interface IGreetingAppService {

		GreetingApp getGreeting(String name);
		GreetingApp putGreeting(String name);
		GreetingApp postGreeting(String name);
}
