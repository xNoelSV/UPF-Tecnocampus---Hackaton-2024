package com.backend.hackathon.hackathon_grup6.domain;

import com.backend.hackathon.hackathon_grup6.application.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity(name = "users")
public class Users {

    @Id
    private String id;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private String email;
    private String gender;
    @Column(unique = true)
    private String username;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public Users(UserDTO userDTO) throws Exception {
        this.id = UUID.randomUUID().toString();
        this.name = userDTO.getName();
        this.firstSurname = userDTO.getFirstSurname();
        this.secondSurname = userDTO.getSecondSurname();
        this.email = userDTO.getEmail();
        this.gender = userDTO.getGender();
        this.username = userDTO.getUsername();
    }
}
