package apiConfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import model.Weather_address;
import processor.ApiProcessor;

@Configuration
@RestController
public class ApiConfig {
	ApiReader api=new ApiReader();
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
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
	        return stepBuilderFactory.get("step1")
	                .<Weather_address, Weather_address> chunk(10)
	                .reader(new ApiReader())
	                .processor(new ApiProcessor())
	                .writer(new ApiWriter())
	                .build();
	    }
	

	 
	 
}
