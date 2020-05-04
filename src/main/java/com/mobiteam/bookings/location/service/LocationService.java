package com.mobiteam.bookings.location.service;

import com.mobiteam.bookings.location.clients.LocationClient;
import com.mobiteam.bookings.location.exceptions.NoCityForIPException;
import com.mobiteam.bookings.location.models.City;
import org.springframework.stereotype.Service;

@Service
public class LocationService {


    private LocationClient locationClient;

    public LocationService(LocationClient locationClient) {
        this.locationClient=locationClient;
    }

    public City getCityByIp(String ipAddress)  {
            return this.locationClient.getLocationByIp(ipAddress).orElseThrow(NoCityForIPException::new);
    }


}
