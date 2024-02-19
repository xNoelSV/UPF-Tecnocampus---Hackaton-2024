package com.backend.hackathon.hackathon_grup6.persistance;

import com.backend.hackathon.hackathon_grup6.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, String> {
    Page<Review> findAllByEventsIdOrderByReviewDateDesc(String EventsId, Pageable pageable);
    Page<Review> findAllByEventsIdOrderBySatisfactionDesc(String EventsId, Pageable pageable);
    Optional<Review> findByEventsIdAndUserId(String EventsId, String userId);
}
