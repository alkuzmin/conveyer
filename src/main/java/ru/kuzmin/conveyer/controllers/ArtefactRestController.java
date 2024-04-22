package ru.kuzmin.conveyer.controllers;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kuzmin.conveyer.exceptions.ArtefactNotFoundException;
import ru.kuzmin.conveyer.services.ArtefactService;
import ru.kuzmin.conveyer.entities.Artefact;

import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping(value = "/artefact", produces = MediaType.APPLICATION_JSON_VALUE)
public class ArtefactRestController {

    @Autowired
    ArtefactService serv;

    @SneakyThrows
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Artefact> saveArtefact(@RequestBody Artefact a) {
        Artefact res = serv.saveArtefact(a);
        return new ResponseEntity<Artefact>(res, new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Artefact> getArtefact(@PathVariable BigInteger id) {
        Optional opt = serv.getArtefactbyId(id);
        if (!opt.isPresent())
            throw new ArtefactNotFoundException("No such artefact");
        Artefact res = (Artefact)opt.get();
        return  new ResponseEntity<Artefact>(res, new HttpHeaders(), HttpStatus.OK);

    }

}
