package com.backend.hackathon.hackathon_grup6.persistance;

import com.backend.hackathon.hackathon_grup6.application.dto.EventsDTO;
import com.backend.hackathon.hackathon_grup6.domain.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, String> {

    @Query("select c from events c where c.available = true order by c.title")
    List<EventsDTO> findEventsByTitle();

    @Query("select c from events c order by c.lastUpdateDate")
    List<EventsDTO> findRecentEvents();

    @Query("SELECT new com.backend.hackathon.hackathon_grup6.application.dto.EventsDTO(e.title, e.description) " +
            "FROM events e " +
            "WHERE lower(e.title) LIKE lower(:keyword) OR lower(e.description) LIKE lower(:keyword) " +
            "ORDER BY e.title")
    List<EventsDTO> findEventsByTitleOrDescriptionContaining(@Param("keyword") String keyword);

    boolean existsByTitle(String title);
}
