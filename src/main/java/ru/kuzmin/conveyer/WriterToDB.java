package ru.kuzmin.conveyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("db")
public class WriterToDB implements ConveyerDataWriter {
    @Autowired
    ArtefactService serv;
    @Override
    public void write(Artefact a) {
        serv.saveArtefact(a);
    }
}
