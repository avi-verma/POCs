package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	@Autowired
	private MovieRepo movieRepo;
	@RequestMapping("/add")
	public  String addNewUser () {
		System.out.println("#########################################################################");
		Movies n = new Movies();
		n.setMovieName("Shole");
		movieRepo.save(n);
		return "Saved";
	}

}
