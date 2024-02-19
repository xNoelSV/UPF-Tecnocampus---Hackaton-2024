package com.backend.hackathon.hackathon_grup6.api.FrontedException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Incorrect parameter")
public class IncorrectRESTParameter extends RuntimeException {
    public IncorrectRESTParameter(String parameter, String value) {
        super("We don't like " + value + "as " + parameter);
    }
}