package com.backend.hackathon.hackathon_grup6.api;

import com.backend.hackathon.hackathon_grup6.application.EventsService;
import com.backend.hackathon.hackathon_grup6.application.dto.LocationDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class LocationRestController {
    private final EventsService eventsService;

    public LocationRestController(EventsService eventService) {
        this.eventsService = eventService;
    }

    @PostMapping("/locations")
    public LocationDTO createLocation(@RequestBody LocationDTO locationDTO) throws Exception {
        return eventsService.createLocation(locationDTO);
    }

    @GetMapping("/locations/{locationsId}")
    public LocationDTO getLocations(@PathVariable String locationsId){
        return eventsService.getLocation(locationsId);
    }

}
