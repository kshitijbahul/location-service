package com.mobiteam.bookings.location.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiteam.bookings.location.models.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class GeoLocationClient implements LocationClient{

    private RestTemplate restTemplate;


    @Value("${location.api.url}")
    String geoLocationAPiUrl;

    public GeoLocationClient(){
        this.restTemplate=new RestTemplate();
    }

    @Override
    public Optional<City> getLocationByIp(String ipAddress)  {
        log.info("The location is {}",geoLocationAPiUrl);
        ResponseEntity<String> response=this.restTemplate.getForEntity(String.format("%s/%s",geoLocationAPiUrl,ipAddress), String.class);
        try {
            JsonNode json= (new ObjectMapper()).readTree(response.getBody());
            return Optional.of(new City(json.get("city").asText(),json.get("regionName").asText(),json.get("lat").asText(),json.get("lon").asText()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
        return Optional.empty();
    }
}
