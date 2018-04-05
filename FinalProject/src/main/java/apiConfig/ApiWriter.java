package apiConfig;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import ch.qos.logback.core.net.SyslogOutputStream;
import model.Weather_address;

public class ApiWriter implements ItemWriter<Weather_address> {

	@Override
	public void write(List<? extends Weather_address> items) throws Exception {
		for(Weather_address i:items)
		System.out.println(i.getMain().getTemp());
		System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
	}

}