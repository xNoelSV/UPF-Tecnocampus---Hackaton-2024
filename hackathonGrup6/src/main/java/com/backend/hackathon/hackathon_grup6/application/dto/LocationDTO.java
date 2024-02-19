package com.backend.hackathon.hackathon_grup6.application.dto;

import com.backend.hackathon.hackathon_grup6.domain.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LocationDTO {
    private String id;
    private String name;
    private String street;
    private String email;

    public LocationDTO(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.street = location.getStreet();
        this.email = location.getEmail();
    }
}
