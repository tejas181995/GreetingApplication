package com.bridelabz.greetingapp.controller;

import java.util.concurrent.atomic.AtomicLong;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridelabz.greetingapp.model.GreetingApp;

@RestController
public class GreetingAppController {
	private static final String template = "Hello, %s!";
	private static AtomicLong counter = new  AtomicLong();
	
	@GetMapping("/GreetMsg_get")
	public GreetingApp getGreetingApp(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new GreetingApp(String.format(template,name), counter.incrementAndGet());
	}
	@PutMapping("/GreetMsg_put")
	public GreetingApp putGreetingApp(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new GreetingApp(String.format(template, name), counter.incrementAndGet());
	}
	@PostMapping("/GreetMsg_post")
	public GreetingApp postGreetingApp(@RequestParam(value="name", defaultValue = "World") String name) {
		return new GreetingApp(String.format(template, name), counter.incrementAndGet());
	}
}
