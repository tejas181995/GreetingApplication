package com.bridelabz.greetingapp.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridelabz.greetingapp.model.GreetingApp;
import com.bridelabz.greetingapp.repositary.IGreetingAppRepositary;

@Service
public class GreetingAppService implements IGreetingAppService {

	private AtomicLong counter = new AtomicLong(); 
	private String template = "Hello, %s !";
	
	@Autowired
	private IGreetingAppRepositary greetingRepo;

	@Override
	public List<GreetingApp> getGreeting() {
		return greetingRepo.findAll();
	}

	@Override
	public GreetingApp getGreetingById(Long id) {
		return greetingRepo.findById(id).get();
	}

	@Override
	public GreetingApp putGreeting(String msg, long id) {
		Optional<GreetingApp> greetApp = greetingRepo.findById(id);
		greetApp.get().setMessage(msg);
		return greetingRepo.save(greetApp.get());
	}

	@Override
	public GreetingApp postGreeting(String name) {
		GreetingApp greetingApp = new GreetingApp(String.format(template, name), counter.incrementAndGet()); 
		return greetingRepo.save(greetingApp);	
	 
	}

	
}
