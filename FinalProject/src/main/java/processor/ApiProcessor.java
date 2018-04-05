package processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.web.client.RestTemplate;

import model.Weather_address;

public class ApiProcessor implements ItemProcessor<Weather_address, Weather_address> {
	RestTemplate restTemplate=new RestTemplate();
	@Override
	public Weather_address process(Weather_address item) throws Exception {
		System.out.println("Kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
			 Weather_address rest= restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q="+item.getName()+"&appid=191cc3c51a402049241235af01f9e78f", Weather_address.class);
			  item.setMainWeather(rest.getMainWeather());
		return item;
	}
}
