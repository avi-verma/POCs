package apiConfig;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import model.Weather_address;

public class ApiWriter implements ItemWriter<Weather_address> {

	@Override
	public void write(List<? extends Weather_address> items) throws Exception {
		System.out.println(items);
		
	}

}
