package com.example.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.MainWeather;
import com.example.model.Weather_info;

@RestController
public class ApiController {
	RestTemplate restTemplate=new RestTemplate();
	ArrayList<MainWeather> list=new ArrayList<>();
	@RequestMapping("/getInfo")
	public ArrayList<MainWeather> getInfo() {
	Weather_info[] cities=restTemplate.getForObject("http://localhost:7171/weather_data", Weather_info[].class);
	for(Weather_info item:cities) {
		Weather_info info=restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q="+item.getName()+"&appid=191cc3c51a402049241235af01f9e78f", Weather_info.class);
		list.add(info.getMain());
	}
	return list;
	}
}
