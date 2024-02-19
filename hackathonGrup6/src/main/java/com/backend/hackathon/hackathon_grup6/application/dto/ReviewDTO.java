package com.backend.hackathon.hackathon_grup6.application.dto;

import com.backend.hackathon.hackathon_grup6.domain.Events;
import com.backend.hackathon.hackathon_grup6.domain.Review;
import com.backend.hackathon.hackathon_grup6.domain.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class ReviewDTO {

    private String id;
    private Events events;
    private Users student;
    private String title;
    private String content;
    private int satisfaction;
    private LocalDate reviewDate;

    public ReviewDTO(Review review) {
        this.id = review.getId();
        this.title = review.getTitle();
        this.content = review.getContent();
        this.satisfaction = review.getSatisfaction();
        this.reviewDate = getReviewDate();
        this.events = review.getEvents();
        this.student = review.getUser();
    }
}
