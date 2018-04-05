package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Person;

@RestController
public class ApiController {
	
	@RequestMapping("/person")
	public List<Person> getperson() {
		ArrayList<Person> person=new ArrayList<>();
		person.add(new Person(12,"avinash","Verma","LAkhimpur"));
		person.add(new Person(12,"anurag","Kumar","Lucknow"));
		return person;
	}
}
