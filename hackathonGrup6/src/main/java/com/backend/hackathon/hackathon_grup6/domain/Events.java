package com.backend.hackathon.hackathon_grup6.domain;

import com.backend.hackathon.hackathon_grup6.application.dto.EventsDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity(name = "events")
public class Events {
    @Id
    private String id;
    @Column(unique = true)
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "Nickname must begin with a capital letter. Also only letters are allowed")
    private String title;
    private String description;
    private LocalDate publicationDate;
    private LocalDate lastUpdateDate;
    private String imageURL;
    @PositiveOrZero
    private double currentPrice;
    private boolean available;
    Duration totalDuration;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private Users organizer;

    @ManyToOne
    @JoinColumn (name = "location_id")
    private Location location;

    public Events(EventsDTO eventsDTO) {
        checkNullArgument(eventsDTO.getTitle());
        checkNullArgument(eventsDTO.getDescription());
        checkNullArgument(eventsDTO.getImageURL());
        checkNullArgument(eventsDTO.getPublicationDate());
        checkNullArgument(eventsDTO.getLastUpdateDate());
        checkNullArgument(eventsDTO.getId());
        initeventsData(eventsDTO);
    }

    private void checkNullArgument(Object argument) {
        if (argument == null)
            throw new IllegalArgumentException("Null argument");
    }

    private void initeventsData(EventsDTO eventsDTO) {
        this.id = UUID.randomUUID().toString();
        this.title = eventsDTO.getTitle();
        this.description = eventsDTO.getDescription();
        this.publicationDate = eventsDTO.getPublicationDate();
        this.lastUpdateDate = eventsDTO.getLastUpdateDate();
        this.imageURL = eventsDTO.getImageURL();
        this.currentPrice = eventsDTO.getCurrentPrice();
        this.available = eventsDTO.isAvailable();
        this.organizer = eventsDTO.getOrganizer();
        this.location = eventsDTO.getLocation();
    }

    public void updateEvents(EventsDTO eventsDTO){
        if (!available){
            this.title = eventsDTO.getTitle();
            this.description = eventsDTO.getDescription();
            this.imageURL = eventsDTO.getImageURL();
        }

        else{
            throw new IllegalArgumentException();
        }
    }

    public void updatePrice(double price){
        if (!available) {
            this.currentPrice = price;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public void setAvailable(boolean available){
        if(available){
            this.available = available;
        }
    }

    private void updateLastUpdateDate() {
        this.lastUpdateDate = LocalDate.now();
    }
}
