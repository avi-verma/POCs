package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Weather_address {
	private long id;
	private String name;
	private MainWeather main;
	public MainWeather getMainWeather() {
		return main;
	}
	public void setMainWeather(MainWeather mainWeather) {
		this.main = mainWeather;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
