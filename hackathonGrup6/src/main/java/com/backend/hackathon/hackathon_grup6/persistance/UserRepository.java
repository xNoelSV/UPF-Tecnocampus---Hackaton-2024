package com.backend.hackathon.hackathon_grup6.persistance;

import com.backend.hackathon.hackathon_grup6.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users, String> {
}
