package config;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import model.Weather;
import processor.WeatherProcessor;
@Configuration
@EnableBatchProcessing
public class WeatherConfig {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Value(value="input/weather_*.csv")
	private Resource[] resources;
	
	@Bean
    public FlatFileItemReader<Weather> reader() {
        FlatFileItemReader<Weather> reader = new FlatFileItemReader<Weather>();
        reader.setLineMapper(new DefaultLineMapper<Weather>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "longitude", "latitude","City","Temperature" });
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Weather>() {{
                setTargetType(Weather.class);
            }});
        }});
        return reader;
    }
	   @Bean
	    public MultiResourceItemReader<Weather> multiResourceItemReader(){
	    	MultiResourceItemReader<Weather> multiResourceItemReader = new MultiResourceItemReader<>();
	    	multiResourceItemReader.setResources(resources);
	    	multiResourceItemReader.setDelegate(reader());
			return multiResourceItemReader;
	    }
	   @Bean
	    public WeatherProcessor processor() {
	        return new WeatherProcessor();
	    }

	    @Bean
		public FlatFileItemWriter<Weather> writer(){
			FlatFileItemWriter<Weather> writer = new FlatFileItemWriter<Weather>();
			writer.setResource(new ClassPathResource("output/weather_output.csv"));
			//writer.setAppendAllowed(true);
			DelimitedLineAggregator<Weather> lineAggregator = new DelimitedLineAggregator<Weather>();
			lineAggregator.setDelimiter(",");
			
			BeanWrapperFieldExtractor<Weather>  fieldExtractor = new BeanWrapperFieldExtractor<Weather>();
			fieldExtractor.setNames(new String[]{"longitude", "latitude","City","Temperature"});
			lineAggregator.setFieldExtractor(fieldExtractor);
			
			writer.setLineAggregator(lineAggregator);
			return writer;
		}

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
	                .<Weather, Weather> chunk(10)
	                .reader(multiResourceItemReader())
	                .writer(writer())
	                .build();
	    }

}
