package com.backend.hackathon.hackathon_grup6.persistance;

import com.backend.hackathon.hackathon_grup6.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,String> {
}
