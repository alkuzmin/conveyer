package ru.kuzmin.conveyer.datawriters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.kuzmin.conveyer.entities.Artefact;
import ru.kuzmin.conveyer.services.ArtefactService;

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
