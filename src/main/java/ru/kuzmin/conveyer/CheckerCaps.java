package ru.kuzmin.conveyer;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class CheckerCaps implements ConveyerDataChecker {
    @Override
    public Artefact check(Artefact a) {

        a.name = a.name.toUpperCase();
        return a;
    }
}
