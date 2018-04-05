package com.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.model.Person;
import com.model.Weather;

@RestController
public class RestCall {
	
	@RequestMapping("/address")
	public int getName() {
		RestTemplate restTemplate=new RestTemplate();
		Person[] person=restTemplate.getForObject("http://localhost:8888/person", Person[].class);
		return person.length;
	}
		
}
