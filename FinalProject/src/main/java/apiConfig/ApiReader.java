package apiConfig;

import java.util.ArrayList;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.web.client.RestTemplate;

import model.Weather_address;

public class ApiReader implements ItemReader<Weather_address> {

	@Override
	public Weather_address read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ");
		 RestTemplate restTemplate=new RestTemplate();
		 Weather_address weather_address=restTemplate.getForObject("http://localhost:7171/weather_data", Weather_address.class);
		return weather_address;
	}
	
}
