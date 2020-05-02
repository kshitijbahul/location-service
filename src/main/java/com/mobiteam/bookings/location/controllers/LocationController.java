package com.mobiteam.bookings.location.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    @GetMapping("/")
    private ResponseEntity sayHello(){
        return ResponseEntity.ok("Hello Locations");
    }
}
