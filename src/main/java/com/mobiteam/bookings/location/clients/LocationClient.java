package com.mobiteam.bookings.location.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mobiteam.bookings.location.models.City;

import java.util.Optional;

public interface LocationClient {

    Optional<City> getLocationByIp(String ipAddress) ;
}
