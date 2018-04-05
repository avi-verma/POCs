package com.example.demo;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
		ArrayList<Weather_address> list=new ArrayList<>();
		@RequestMapping("/weather_data")
		public List<Weather_address> getData(){
			
			list.add(new Weather_address(235,"Bangalore, IN"));
			list.add(new Weather_address(25,"Delhi, IN"));
			
			return list;
		}
}
