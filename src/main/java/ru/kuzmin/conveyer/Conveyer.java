package ru.kuzmin.conveyer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Component
class Conveyer {


    @Setter
    @Getter
    @Autowired
    @Qualifier("db")
    ConveyerDataReader dr;
    @Setter
    @Getter
    @Autowired
    @Qualifier("db")
    ConveyerDataWriter dw;

    @Autowired
    public List<ConveyerDataChecker> checks;

    public void perform() {
        Artefact arg = dr.read(BigInteger.valueOf(1));
        for (ConveyerDataChecker chk : checks) {
            arg = chk.check(arg);
        }
        dw.write(arg);
    }

    ;
}
