package com.backend.hackathon.hackathon_grup6.api;

import com.backend.hackathon.hackathon_grup6.application.EventsService;
import com.backend.hackathon.hackathon_grup6.application.dto.FloraIFaunaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class FloraIFaunaRestController {
    private final EventsService floraIFaunaService;

    public FloraIFaunaRestController(EventsService floraIFaunaService) {
        this.floraIFaunaService = floraIFaunaService;
    }

    @PostMapping("/floraifauna")
    public FloraIFaunaDTO createFloraIFauna(@RequestBody FloraIFaunaDTO floraIFaunaDTO) throws Exception {
        return floraIFaunaService.createFloraIFauna(floraIFaunaDTO);
        }

        @GetMapping("/floraifauna/{floraIFaunaId}")
        public FloraIFaunaDTO getFloraIFauna(@PathVariable String floraIFaunaId) throws Exception {
            return floraIFaunaService.getFloraIFauna(floraIFaunaId);
    }
}
