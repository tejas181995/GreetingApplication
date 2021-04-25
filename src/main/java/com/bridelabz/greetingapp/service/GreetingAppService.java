package com.bridelabz.greetingapp.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.bridelabz.greetingapp.model.GreetingApp;

@Service
public class GreetingAppService implements IGreetingAppService {

	private AtomicLong counter = new AtomicLong();
	private String template = "Hello, %s!";
	
	@Override
	public GreetingApp getGreeting(String name) {
		return new GreetingApp(String.format(template,name), counter.incrementAndGet());
	}

	@Override
	public GreetingApp putGreeting(String name) {
		return new GreetingApp(String.format(template,name), counter.incrementAndGet());
	}

	@Override
	public GreetingApp postGreeting(String name) {
		return new GreetingApp(String.format(template,name), counter.incrementAndGet());
	}

}
