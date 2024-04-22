package ru.kuzmin.conveyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ArtefactService {

   @Autowired
    ArtefactRepo repo;
    Artefact newArtefact(String name)
    {
        Artefact a = new Artefact(name);
        repo.save(a);
        return a;
    }

    Optional<Artefact> getArtefactbyId(BigInteger id)
    {
        return repo.findById(id);

    }

    List<Artefact> getAllArtefact()
    {
        return (List<Artefact>) repo.findAll();
    }
}
