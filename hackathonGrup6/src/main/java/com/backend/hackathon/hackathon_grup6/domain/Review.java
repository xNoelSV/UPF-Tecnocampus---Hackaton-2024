package com.backend.hackathon.hackathon_grup6.domain;


import com.backend.hackathon.hackathon_grup6.application.dto.ReviewDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity(name = "reviews")
public class Review {

    @Id
    private String id;

    @ManyToOne
    @MapsId("events_id")
    private Events events;

    @ManyToOne
    @MapsId("user_id")
    private Users user;

    private String title;
    private String content;
    private int satisfaction;
    private LocalDate reviewDate;

    public Review(ReviewDTO reviewDTO, Events events, Users user) {
        this.id = new ReviewId(user.getId(),events.getId()).toString();
        this.title = reviewDTO.getTitle();
        this.content = reviewDTO.getContent();
        this.satisfaction = reviewDTO.getSatisfaction();
        this.reviewDate = getReviewDate();
        this.events = events;
        this.user = user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }
}
