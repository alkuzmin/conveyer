package ru.kuzmin.conveyer;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(1)
public class CheckerSpaces implements ConveyerDataChecker {
    @Override
    public Artefact check(Artefact a) {
        String res = "";
        for (String s : a.name.split("\n")) {
            res += s.trim();
            res += "\n";
        }
        a.setName(res);
        return a;
    }
}
