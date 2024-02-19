package com.backend.hackathon.hackathon_grup6.application.dto;

import com.backend.hackathon.hackathon_grup6.domain.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserDTO {

    private String id;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private String email;
    private String gender;
    private String username;

    public UserDTO(Users users) {
        this.id = users.getId();
        this.name = users.getName();
        this.firstSurname = users.getFirstSurname();
        this.secondSurname = users.getSecondSurname();
        this.email = users.getEmail();
        this.gender = users.getGender();
        this.username = users.getUsername();
    }
}
