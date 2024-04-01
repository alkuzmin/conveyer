package ru.kuzmin.conveyer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class Conveyer {


    @Setter
    @Getter
    @Autowired
    ConveyerDataReader dr;
    @Setter
    @Getter
    @Autowired
    ConveyerDataWriter dw;

    @Autowired
    public List<ConveyerDataChecker> checks;// = new ArrayList<>();

    public void perform() {
        String arg = dr.read();
        for (ConveyerDataChecker chk : checks) {
            arg = chk.check(arg);
        }
        dw.write(arg);
    }

    ;
}