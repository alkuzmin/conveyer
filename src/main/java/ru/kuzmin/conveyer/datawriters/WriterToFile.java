package ru.kuzmin.conveyer.datawriters;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.kuzmin.conveyer.Loggable;
import ru.kuzmin.conveyer.entities.Artefact;

import java.io.FileWriter;
import java.io.IOException;

@Component
@Qualifier("file")
@Loggable
public class WriterToFile implements ConveyerDataWriter {
    public WriterToFile( @Value("${spring.application.pathoutput}") String path) {
        this.pathoutput = path;
    }

    private String pathoutput;

     @Override
    public void write(Artefact a) {
        FileWriter fw;
        try {
            fw = new FileWriter(pathoutput);
            fw.write(a.getName());
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
