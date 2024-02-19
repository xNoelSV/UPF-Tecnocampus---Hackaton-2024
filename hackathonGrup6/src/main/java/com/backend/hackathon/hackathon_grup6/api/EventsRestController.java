package com.backend.hackathon.hackathon_grup6.api;

import com.backend.hackathon.hackathon_grup6.application.EventsService;
import com.backend.hackathon.hackathon_grup6.application.dto.EventsDTO;
import com.backend.hackathon.hackathon_grup6.application.dto.ReviewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EventsRestController {
    private final EventsService eventsService;

    public EventsRestController(EventsService eventsService){
        System.out.println("events controller");
        this.eventsService = eventsService;
    }

    @PatchMapping("/events/{eventsId}/availables/{available}")
    public EventsDTO updateAvailability(@PathVariable String eventsId, @PathVariable boolean available){
        return eventsService.updateAvailability(eventsId, available);
    }

    @GetMapping("/events/availables")
    public List<EventsDTO> getAvailableeventss() {
        return eventsService.getAvailableEvents();
    }

    @PostMapping("/events")
    @ResponseStatus(HttpStatus.CREATED)
    public EventsDTO createevents(@RequestBody EventsDTO eventsDTO) {
        return eventsService.createEvents(eventsDTO);
    }

    @GetMapping("/events/{eventsId}")
    public EventsDTO getevents(@PathVariable String eventsId) {
        return eventsService.getEvents(eventsId);
    }

    @PostMapping("/events/{eventsId}")
    public EventsDTO updateevents(@PathVariable String eventsId, @RequestBody EventsDTO eventsDTO) {
        return eventsService.updateEvents(eventsId, eventsDTO);
    }

    @PatchMapping("/events/{eventsId}/prices/{price}")
    public EventsDTO updatePrice(@PathVariable String eventsId, @PathVariable double price) {
        return eventsService.updatePrice(eventsId, price);
    }
    @GetMapping("/events/search")
    public List<EventsDTO> searcheventss(@RequestParam String keyword) {
        return eventsService.getEventsByKeyword(keyword);
    }

    @GetMapping("/events/recent")
    public List<EventsDTO> getRecentevents() {
        return eventsService.getRecentEvents();
    }

    @PostMapping("/events/students/{studentId}/reviews/{reviewId}/updates")
    public ReviewDTO updateReview(@PathVariable String studentId, @PathVariable String reviewId, @RequestBody ReviewDTO reviewDTO) {
        return eventsService.updateReview(reviewId, studentId, reviewDTO);
    }

    @GetMapping("/events/{eventsId}/reviews")
    public Page<ReviewDTO> geteventsReviews(@PathVariable String eventsId,
                                            @RequestParam(defaultValue = "date") String sortBy,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return eventsService.getEventsReviews(eventsId, sortBy, pageable);
    }

    @GetMapping("/events")
    public List<EventsDTO> getAllEvents() {
        return eventsService.getAllEvents();
    }

    @PostMapping("/events/{eventsId}/students/{studentId}/reviews")
    public ReviewDTO addReview(@PathVariable String eventsId, @PathVariable String studentId, @RequestBody ReviewDTO reviewDTO) {
        return  eventsService.addReview(studentId, eventsId, reviewDTO);
    }
}
