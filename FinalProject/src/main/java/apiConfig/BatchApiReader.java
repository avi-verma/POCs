package apiConfig;


import org.springframework.batch.item.ItemReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import model.Weather_address;

import java.util.Arrays;
import java.util.List;


class BatchApiReader implements ItemReader<Weather_address> {

   

    private final String apiUrl;
    private final RestTemplate restTemplate;

    private int nextWeatherIndex;
    private List<Weather_address> weatherData;

    public BatchApiReader(String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
        nextWeatherIndex = 0;
    }

    @Override
    public Weather_address read() throws Exception {
      
        if (weatherDataIsNotInitialized()) {
            weatherData = fetchWeatherDataFromAPI();
        }

        Weather_address nextWeather = null;

        if (nextWeatherIndex < weatherData.size()) {
            nextWeather = weatherData.get(nextWeatherIndex);
            nextWeatherIndex++;
        }

         return nextWeather;
    }

    private boolean weatherDataIsNotInitialized() {
        return this.weatherData == null;
    }

    private List<Weather_address> fetchWeatherDataFromAPI() {
        ResponseEntity<Weather_address[]> response = restTemplate.getForEntity(apiUrl, Weather_address[].class);
        Weather_address[] weatherData = response.getBody();
        

        return Arrays.asList(weatherData);
    }
}
