package com.bridelabz.greetingapp.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridelabz.greetingapp.model.GreetingApp;

@Repository
public interface IGreetingAppRepositary extends JpaRepository<GreetingApp, Long> {
	
}
