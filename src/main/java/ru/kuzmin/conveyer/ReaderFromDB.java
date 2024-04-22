package ru.kuzmin.conveyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("db")
public class ReaderFromDB implements ConveyerDataReader {

    @Autowired
    ArtefactService serv;
    @Override
    public String read() {
        List<Artefact> lst = serv.getAllArtefact();
        if (lst==null) return null;
        return lst.toString();
    }
}
