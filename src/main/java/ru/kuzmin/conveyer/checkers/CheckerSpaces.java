package ru.kuzmin.conveyer.checkers;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.kuzmin.conveyer.entities.Artefact;

@Component
@Order(1)
public class CheckerSpaces implements ConveyerDataChecker {
    @Override
    public Artefact check(Artefact a) {
        String res = "";
        for (String s : a.getName().split("\n")) {
            res += s.trim();
            res += "\n";
        }
        a.setName(res);
        return a;
    }
}
