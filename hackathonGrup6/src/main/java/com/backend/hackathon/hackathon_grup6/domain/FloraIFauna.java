package com.backend.hackathon.hackathon_grup6.domain;

import com.backend.hackathon.hackathon_grup6.application.dto.FloraIFaunaDTO;
import com.backend.hackathon.hackathon_grup6.application.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;


@NoArgsConstructor
@Getter
@Entity(name = "floraIfauna")
public class FloraIFauna {

    @ManyToOne
    @JoinColumn(name = "events_id")
    private Events events;

        @Id
        @Column(unique = true)
        private String id;
        private String name; //scientific name
        private String commonName;
        private String type; //description of the flower



        public FloraIFauna(FloraIFaunaDTO floraIFaunaDTO) throws Exception {
            this.id = UUID.randomUUID().toString();
            this.name = floraIFaunaDTO.getName();
            this.commonName = floraIFaunaDTO.getCommonName();
            this.type = floraIFaunaDTO.getType();
            this.events = floraIFaunaDTO.getEvents();
        }


}
