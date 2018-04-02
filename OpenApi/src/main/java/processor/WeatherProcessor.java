package processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import model.Weather;



public class WeatherProcessor implements ItemProcessor<Weather, Weather> {

    private static final Logger log = LoggerFactory.getLogger(WeatherProcessor.class);

    @Override
    public Weather process(final Weather weather) throws Exception {
        
    	final int temp= (9/5) * weather.getTemperature() + 32;
        final Weather transformedWeather = new Weather(weather.getLongitude(),weather.getLatitude(),weather.getCity(),temp);

        log.info("Converting (" + weather + ") into (" + transformedWeather + ")");

        return transformedWeather;
    }



}
