package ru.kuzmin.conveyer.datareaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.kuzmin.conveyer.entities.Artefact;
import ru.kuzmin.conveyer.services.ArtefactService;

import java.math.BigInteger;
import java.util.Optional;

@Component
@Qualifier("db")
public class ReaderFromDB implements ConveyerDataReader {

    @Autowired
    ArtefactService serv;
    @Override
    public Artefact read(BigInteger id) {
        Optional res = serv.getArtefactbyId(id);
        return  res.isPresent()?(Artefact)res.get():null;
    }
}
