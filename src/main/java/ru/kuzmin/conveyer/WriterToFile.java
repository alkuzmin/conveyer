package ru.kuzmin.conveyer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
@Loggable
public class WriterToFile implements ConveyerDataWriter {
    public WriterToFile( @Value("${spring.application.pathoutput}") String path) {
        this.pathoutput = path;
    }

    private String pathoutput;

     @Override
    public void write(String str) {
        FileWriter fw;
        try {
            fw = new FileWriter(pathoutput);
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
