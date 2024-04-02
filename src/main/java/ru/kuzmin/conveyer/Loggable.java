package ru.kuzmin.conveyer;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Loggable {
    String value() default "C:/temp/logs.log";
}
