package com.backend.hackathon.hackathon_grup6.persistance;

import com.backend.hackathon.hackathon_grup6.domain.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSecurityRepository extends JpaRepository<UserSecurity, Long> {
    Optional<UserSecurity> findByUsername(String email);

}
