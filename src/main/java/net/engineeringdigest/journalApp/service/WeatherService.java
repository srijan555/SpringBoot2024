package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.cache.AppCache;
import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//@Component
@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;
    //String endpoint = "https://api.weatherstack.com/current?access_key=e5fa4149ce2556aadf27ffcd93859663&query=Patna";
    //String API = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    public WeatherResponse getWeather(String city){
        /*
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.set("key","value");
        User user= User.builder().username("Srijan").password("Srijan").build();
        HttpEntity<User> httpEntity = new HttpEntity<>(user,httpHeaders);
        */
        String finalAPI= appCache.APP_CACHE.get("weather_api").replace("<city>",city).replace("<apiKey>",apiKey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);//deserialization
        WeatherResponse body = response.getBody();
        return body;
    }

}
