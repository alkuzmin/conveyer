package ru.kuzmin.conveyer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ArtefactNotFoundException extends ResponseStatusException {
    public ArtefactNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

}