package com.backend.hackathon.hackathon_grup6.application.dto;


import com.backend.hackathon.hackathon_grup6.domain.Events;
import com.backend.hackathon.hackathon_grup6.domain.FloraIFauna;
import com.backend.hackathon.hackathon_grup6.domain.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
public class FloraIFaunaDTO {

    private String id;
    private String name; //scientific name
    private String commonName;
    private String type; //description of the flower
    private Events events;

    public FloraIFaunaDTO(FloraIFauna floraIFauna) throws Exception {
        this.id = UUID.randomUUID().toString();
        this.name = floraIFauna.getName();
        this.commonName = floraIFauna.getCommonName();
        this.type = floraIFauna.getType();
        this.events = floraIFauna.getEvents();
    }
}
