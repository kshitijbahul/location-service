package com.mobiteam.bookings.location.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class City {
    private String name;
    private String state;
    private String latitude;
    private String longitude;
}
