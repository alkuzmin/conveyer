package ru.kuzmin.conveyer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication ( exclude={DataSourceAutoConfiguration.class})
public class ConveyerApplication {
    //@Value("${path.input}") private static String inputpath;

    public static void main(String[] args) {
        ApplicationContext ctx =  SpringApplication.run(ConveyerApplication.class, args);
       //System.out.println(inputpath);
        Conveyer conv = ctx.getBean(Conveyer.class);
//        conv.checks.add(new CheckerSpaces());
//        conv.checks.add(new CheckerCaps());
//        conv.setDr(new ReaderFromFile());
//        conv.setDw(new WriterToFile());
        conv.perform();
    }

}
