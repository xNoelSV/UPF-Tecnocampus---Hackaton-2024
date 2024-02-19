package com.backend.hackathon.hackathon_grup6.application.dto;

import com.backend.hackathon.hackathon_grup6.domain.Events;
import com.backend.hackathon.hackathon_grup6.domain.Location;
import com.backend.hackathon.hackathon_grup6.domain.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class EventsDTO {

    private String id;
    private String title;
    private String description;
    private LocalDate publicationDate;
    private LocalDate lastUpdateDate;
    private String imageURL;
    private double currentPrice;
    private boolean available;
    private Users organizer;
    private Duration totalDuration;
    private String teacherName;
    private Location location;

    public EventsDTO(Events events){
        this.id = events.getId();
        this.title = events.getTitle();
        this.description = events.getDescription();
        this.publicationDate = LocalDate.now();
        this.lastUpdateDate = LocalDate.now();
        this.imageURL = events.getImageURL();
        this.currentPrice = events.getCurrentPrice();
        this.available = false;
        this.organizer = events.getOrganizer();
        this.location = events.getLocation();
    }

    public EventsDTO(String title, String description, LocalDate publicationDate, LocalDate lastUpdateDate, String imageURL, double currentPrice) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.imageURL = imageURL;
        this.currentPrice = currentPrice;
        this.available = false;
    }

    public EventsDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public EventsDTO(String title, String description, String teacherName, Duration totalDuration){
        this.title = title;
        this.description = description;
        this.teacherName = teacherName;
        this.totalDuration = totalDuration;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available){ this.available = available; }
}
