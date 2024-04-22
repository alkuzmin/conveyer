package ru.kuzmin.conveyer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication ( exclude={DataSourceAutoConfiguration.class})
public class ConveyerApplication {


    public static void main(String[] args) throws Exception{
        ApplicationContext ctx =  SpringApplication.run(ConveyerApplication.class, args);

        Conveyer conv = ctx.getBean(Conveyer.class);

        conv.perform();

    }

}
