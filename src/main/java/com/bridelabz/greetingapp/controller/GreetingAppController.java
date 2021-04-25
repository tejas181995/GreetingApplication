package com.bridelabz.greetingapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<List<GreetingApp>> getGreeting(){
		return new ResponseEntity<>(greetingAppService.getGreeting(), HttpStatus.OK);
	}
	@GetMapping("/GreetMsg_get/{id}")
	public ResponseEntity<GreetingApp> getGreetingById(@PathVariable long id){
		return new ResponseEntity<>(greetingAppService.getGreetingById(id), HttpStatus.OK );
	}
	@PutMapping("/GreetMsg_put/{id}")
	public ResponseEntity<GreetingApp> putGreeting(@RequestParam(value = "msg", defaultValue = "not provided") String msg, @PathVariable Long id){
		return new ResponseEntity<>(greetingAppService.putGreeting(msg, id), HttpStatus.ACCEPTED);
	}
	@PostMapping("/GreetMsg_post")
	public ResponseEntity<GreetingApp> postGreeting(@RequestParam(value="firstName") Optional<String> firstName, 
			@RequestParam(value="lastName") Optional<String> lastName){
		String name = "";
		if(firstName.isPresent())
			name += firstName.get();
		if(lastName.isPresent())
			name += " " + lastName.get();
		if(name.length() == 0)
			name = "Hello World";
		return new ResponseEntity<>(greetingAppService.postGreeting(name), HttpStatus.CREATED);
	}
	@DeleteMapping("/greeting_delete/{id}")
	public ResponseEntity<GreetingApp> deleteGreeting(@PathVariable long id){
		return new ResponseEntity<>(greetingAppService.deleteGreeting(id), HttpStatus.ACCEPTED);
	}
}

