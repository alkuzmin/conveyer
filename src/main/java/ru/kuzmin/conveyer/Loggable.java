package ru.kuzmin.conveyer;

public @interface Loggable {
    String value() default "C:/temp/logs.log"
}
