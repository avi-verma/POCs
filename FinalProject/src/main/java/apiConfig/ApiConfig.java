package apiConfig;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import model.Weather_address;
import processor.ApiProcessor;

@Configuration
@RestController
public class ApiConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	RestTemplate restTemplate=new RestTemplate();
	Weather_address[] weather=restTemplate.getForObject("http://localhost:7171/weather_data", Weather_address[].class);
	double chunks=Math.sqrt(new Double(weather.length));
	 @Bean
	    public Job myJob() {
	        return jobBuilderFactory.get("myJob")
	                .incrementer(new RunIdIncrementer())
	                .flow(step1())
	                .end()
	                .build();
	    }

	    @Bean
	    public Step step1() {
	    	System.out.println(weather.length);
	    	System.out.println((int)Math.ceil(chunks));
	        return stepBuilderFactory.get("step1")
	                .<Weather_address, Weather_address> chunk((int)Math.ceil(chunks))
	                .reader(new BatchApiReader("http://localhost:7171/weather_data",restTemplate))
	                .processor(new ApiProcessor())
	                .writer(new ApiWriter())
	                .build();
	    }
	

	 
	 
}
