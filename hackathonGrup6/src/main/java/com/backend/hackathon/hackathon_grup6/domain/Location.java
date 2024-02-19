package com.backend.hackathon.hackathon_grup6.domain;

import com.backend.hackathon.hackathon_grup6.application.dto.LocationDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity(name = "location")
public class Location {

    @Id
    @Column(unique = true)
    private String id;
    private String name;
    private String street;
    private String email;

    public Location(LocationDTO locationDTO) throws Exception {
        this.id = UUID.randomUUID().toString();
        this.name = locationDTO.getName();
        this.street = locationDTO.getStreet();
        this.email = locationDTO.getEmail();
    }


}
