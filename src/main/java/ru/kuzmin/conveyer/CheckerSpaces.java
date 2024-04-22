package ru.kuzmin.conveyer;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(1)
public class CheckerSpaces implements ConveyerDataChecker {
    @Override
    public String check(String str) {
        String res = "";
        for (String s : str.split("\n")) {
            res += s.trim();
            res += "\n";
        }

        return res;
    }
}
