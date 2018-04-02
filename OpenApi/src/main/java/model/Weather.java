package model;

import java.io.Serializable;

public class Weather implements Serializable{

	private static final long serialVersionUID = -6402068923614583448L;
	private String longitude;
    private String latitude;
    private String City;
    private Integer Temperature;
    
     public Weather() {
		// TODO Auto-generated constructor stub
	}

	public Weather(String longitude, String latitude, String City, Integer Temperature) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.City = City;
		this.Temperature = Temperature;
	}

	
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public Integer getTemperature() {
		return Temperature;
	}

	public void setTemperature(Integer temperature) {
		Temperature = temperature;
	}

	
}