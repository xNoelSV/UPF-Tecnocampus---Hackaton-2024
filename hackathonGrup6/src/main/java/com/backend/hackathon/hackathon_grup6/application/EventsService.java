package com.backend.hackathon.hackathon_grup6.application;

import com.backend.hackathon.hackathon_grup6.application.Exception.DuplicateEventsTitleException;
import com.backend.hackathon.hackathon_grup6.application.Exception.InvalidPriceException;
import com.backend.hackathon.hackathon_grup6.application.Exception.InvalidTitleException;
import com.backend.hackathon.hackathon_grup6.application.dto.*;
import com.backend.hackathon.hackathon_grup6.domain.*;
import com.backend.hackathon.hackathon_grup6.persistance.EventsRepository;
import com.backend.hackathon.hackathon_grup6.persistance.FloraIFaunaRepository;
import com.backend.hackathon.hackathon_grup6.persistance.LocationRepository;
import com.backend.hackathon.hackathon_grup6.persistance.ReviewRepository;
import com.backend.hackathon.hackathon_grup6.persistance.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Controller
public class EventsService {
    private final EventsRepository eventsRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final LocationRepository locationRepository;
    private final FloraIFaunaRepository floraIFaunaRepository;

    public EventsService(EventsRepository eventsRepository, UserRepository userRepository,
                         ReviewRepository reviewRepository,LocationRepository locationRepository,
                         FloraIFaunaRepository floraIFaunarepository) {
        this.eventsRepository = eventsRepository;
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
        this.locationRepository = locationRepository;
        this.floraIFaunaRepository = floraIFaunarepository;
    }

    public EventsDTO updateEvents(String eventId, EventsDTO eventsDTO) {
        Events events = eventsRepository.findById(eventId).orElseThrow();
        events.updateEvents(eventsDTO);
        eventsRepository.save(events);
        return new EventsDTO(events);
    }

    public EventsDTO getEvents(String eventId) {
        Events event = eventsRepository.findById(eventId).orElseThrow();
        return new EventsDTO(event);
    }


    @Transactional
    public EventsDTO updatePrice(String eventId, double price){
        if (price < 0) {
            throw new InvalidPriceException(price);
        }
        Events event = eventsRepository.findById(eventId).orElseThrow();
        event.updatePrice(price);
        return new EventsDTO(event);
    }
    @Transactional
    public EventsDTO updateAvailability(String eventId, boolean newAvailability){
        Events events = eventsRepository.getById(eventId);
        events.setAvailable(newAvailability);
        return new EventsDTO(events);
    }

    public List<EventsDTO> getAvailableEvents(){
        return eventsRepository.findEventsByTitle();
    }

    public EventsDTO createEvents(EventsDTO eventsDTO) {
        if (eventsRepository.existsByTitle(eventsDTO.getTitle())) {
            throw new DuplicateEventsTitleException(eventsDTO.getTitle());
        }
        if (!Character.isUpperCase(eventsDTO.getTitle().charAt(0))) {
            throw new InvalidTitleException();
        }
        eventsDTO.setAvailable(false);
        Events event = new Events(eventsDTO);

        eventsRepository.save(event);
        return new EventsDTO(event);
    }

    public List<EventsDTO> getEventsByKeyword(String keyword) {
        return eventsRepository.findEventsByTitleOrDescriptionContaining(keyword);
    }

    public UserDTO getUser(String userId){
        Users users = userRepository.findById(userId).orElseThrow();
        return new UserDTO(users);
    }

    public List<EventsDTO> getRecentEvents() {
        return eventsRepository.findRecentEvents();
    }


    @Transactional
    public ReviewDTO updateReview(String userId, String reviewId, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(reviewId).orElseThrow();

        if (!review.getUser().getId().equals(userId)) {
            throw new IllegalStateException("Users can only modify their own reviews");
        }

        review.setTitle(reviewDTO.getTitle());
        review.setContent(reviewDTO.getContent());
        review.setSatisfaction(reviewDTO.getSatisfaction());
        review.setReviewDate(LocalDate.now());

        reviewRepository.save(review);
        return new ReviewDTO(review);
    }

    public Page<ReviewDTO> getEventsReviews(String eventId, String sortBy, Pageable pageable) {
        Page<Review> reviews;
        if ("satisfaction".equals(sortBy)) {
            reviews = reviewRepository.findAllByEventsIdOrderBySatisfactionDesc(eventId, pageable);
        } else {
            reviews = reviewRepository.findAllByEventsIdOrderByReviewDateDesc(eventId, pageable);
        }
        return reviews.map(ReviewDTO::new);
    }

    public List<EventsDTO> getAllEvents() {
        List<Events> events = eventsRepository.findAll();
        return events.stream()
                .map(event -> new EventsDTO(
                        event.getTitle(),
                        event.getDescription(),
                        event.getOrganizer().getName(),
                        event.getTotalDuration()))
                .collect(Collectors.toList());
    }


    public ReviewDTO addReview(String userId, String eventId, ReviewDTO reviewDTO) {
        Events event = eventsRepository.findById(eventId)
                .orElseThrow(() -> new NoSuchElementException("event not found"));
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        Review review = reviewRepository.findByEventsIdAndUserId(eventId,userId)
                .orElse(new Review(reviewDTO, event, user));

        review.setTitle(reviewDTO.getTitle());
        review.setContent(reviewDTO.getContent());
        review.setSatisfaction(reviewDTO.getSatisfaction());
        review.setReviewDate(LocalDate.now());

        review = reviewRepository.save(review);
        return new ReviewDTO(review);
    }

    public UserDTO createUser(UserDTO userDTO) throws Exception {
        Users user = new Users(userDTO);
        userRepository.save(user);
        return userDTO;
    }
    public LocationDTO createLocation(LocationDTO locationDTO) throws Exception {
        Location location = new Location(locationDTO);
        locationRepository.save(location);
        return locationDTO;
    }
    public LocationDTO getLocation(String locationId){
        Location location = locationRepository.findById(locationId).orElseThrow();
        return new LocationDTO(location);
    }

    public FloraIFaunaDTO createFloraIFauna(FloraIFaunaDTO floraIFaunaDTO) throws Exception {
        FloraIFauna flora = new FloraIFauna(floraIFaunaDTO);
        floraIFaunaRepository.save(flora);
        return floraIFaunaDTO;
    }
    public FloraIFaunaDTO getFloraIFauna(String floraIFaunaId) throws Exception {
        FloraIFauna floraIFauna = floraIFaunaRepository.findById(floraIFaunaId).orElseThrow();
        return new FloraIFaunaDTO(floraIFauna);
    }
}
