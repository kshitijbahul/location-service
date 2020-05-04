package com.mobiteam.bookings.location.controllers;

import com.mobiteam.bookings.location.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {
    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    private ResponseEntity sayHello(@RequestParam(name="ipAddress",defaultValue = "") String ipAddress,@RequestParam(name = "state",defaultValue = "") String State){
        return ResponseEntity.ok(this.locationService.getCityByIp(ipAddress));
    }
}
