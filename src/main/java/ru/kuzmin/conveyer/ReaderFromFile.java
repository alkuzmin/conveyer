package ru.kuzmin.conveyer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Component
public class ReaderFromFile implements ConveyerDataReader {

    public ReaderFromFile( @Value("${spring.application.pathinput}") String path) {
        this.pathinput = path;
    }
//    public ReaderFromFile(String path) {
//        this.path = path;
//    }

    //public ReaderFromFile(String path) {
    //    this.path = path;
    //}

   // public ReaderFromFile(){};



    public String getPath() {
        return pathinput;
    }

//    public void setPath(String path) {
//        this.path = path;
//    }


    //@Value("${spring.application.pathinput}")
    private String pathinput;

    @Override
    public String read() {
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

        return res;
    }
}
