package com.bridelabz.greetingapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridelabz.greetingapp.model.GreetingApp;
import com.bridelabz.greetingapp.service.IGreetingAppService;

@RestController
@RequestMapping("/")
public class GreetingAppController {
	@Autowired
	private IGreetingAppService greetingAppService;
	
	@GetMapping("/GreetMsg_get")
	public ResponseEntity<GreetingApp> getGreeting(@RequestParam(value="firstName") Optional<String> firstName, 
			@RequestParam(value="lastName") Optional<String> lastName){
		String name = "";
		if(firstName.isPresent())
			name += firstName.get();
		if(lastName.isPresent())
			name += " " + lastName.get();
		if(name.length() == 0)
			name = "Hello World";
		return new ResponseEntity<>(greetingAppService.getGreeting(name), HttpStatus.OK);
	}
	@PutMapping("/GreetMsg_put")
	public ResponseEntity<GreetingApp> putGreeting(@RequestParam(value = "name", defaultValue = "World") String name){
		return new ResponseEntity<>(greetingAppService.getGreeting(name), HttpStatus.ACCEPTED);
	}
	@PostMapping("/GreetMsg_post")
	public ResponseEntity<GreetingApp> postGreeting(@RequestParam(value = "name", defaultValue = "World") String name){
		return new ResponseEntity<>(greetingAppService.getGreeting(name), HttpStatus.CREATED);
	}
}
