package com.backend.hackathon.hackathon_grup6.api;

import com.backend.hackathon.hackathon_grup6.application.EventsService;
import com.backend.hackathon.hackathon_grup6.application.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersRestController {
    private final EventsService eventsService;

    public UsersRestController(EventsService courseService) {
        this.eventsService = courseService;
    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO userDTO) throws Exception {
            return eventsService.createUser(userDTO);
    }

    @GetMapping("/users/{userId}")
    public UserDTO getUser(@PathVariable String userId){
        return eventsService.getUser(userId);
    }

}
