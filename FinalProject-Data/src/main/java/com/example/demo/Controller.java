package com.example.demo;


import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
		@RequestMapping("/weather_data")
		public Weather_address getData(){
			
			return  new Weather_address(235,"Bangalore, IN");
			
			
			
		}
}
