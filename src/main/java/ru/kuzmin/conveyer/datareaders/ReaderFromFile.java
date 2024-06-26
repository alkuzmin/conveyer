package ru.kuzmin.conveyer.datareaders;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.kuzmin.conveyer.Loggable;
import ru.kuzmin.conveyer.entities.Artefact;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

@Component
@Qualifier("file")
@Loggable
public class ReaderFromFile implements ConveyerDataReader {

    public ReaderFromFile( @Value("${spring.application.pathinput}") String path) {
        this.pathinput = path;
    }



    public String getPath() {
        return pathinput;
    }


    private String pathinput;

    @Override
    public Artefact read(BigInteger id) {
        System.out.println("inputpath = "+ getPath());
        String res = "";
        try {
            Scanner sc = new Scanner(new File(getPath()));
            int c = 0;

            while (sc.hasNextLine() && c < 10) {
                res += ("\n" + sc.nextLine());
                c++;
            }
            System.out.println(res);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return new Artefact(res);
    }
}
