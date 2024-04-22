package ru.kuzmin.conveyer.checkers;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.kuzmin.conveyer.entities.Artefact;

@Component
@Order(2)
public class CheckerCaps implements ConveyerDataChecker {
    @Override
    public Artefact check(Artefact a) {

        a.setName(a.getName().toUpperCase());
        return a;
    }
}
