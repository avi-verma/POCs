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
			
			list.add(new Weather_address("Bangalore, IN"));
			list.add(new Weather_address("Delhi, IN"));
			list.add(new Weather_address("Chennai, IN"));
			list.add(new Weather_address("Lucknow, IN"));
			list.add(new Weather_address("Pune, IN"));
			list.add(new Weather_address("Agra, IN"));
			list.add(new Weather_address("Varanasi, IN"));
			list.add(new Weather_address("Allahabad, IN"));
			list.add(new Weather_address("Jammu, IN"));
			list.add(new Weather_address("Shimla, IN"));
			list.add(new Weather_address("New York, US"));
			list.add(new Weather_address("London, GB"));
			list.add(new Weather_address("Beijing, CN"));
			list.add(new Weather_address("Mumbai, IN"));
			
			
			return list;
		}
}
