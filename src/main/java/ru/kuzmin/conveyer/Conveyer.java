package ru.kuzmin.conveyer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.kuzmin.conveyer.checkers.ConveyerDataChecker;
import ru.kuzmin.conveyer.datareaders.ConveyerDataReader;
import ru.kuzmin.conveyer.datawriters.ConveyerDataWriter;
import ru.kuzmin.conveyer.entities.Artefact;

import java.math.BigInteger;
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
        Artefact arg = dr.read(BigInteger.valueOf(2));
        for (ConveyerDataChecker chk : checks) {
            arg = chk.check(arg);
        }
        dw.write(arg);
    }

    ;
}
