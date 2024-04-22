package ru.kuzmin.conveyer.datareaders;

import ru.kuzmin.conveyer.entities.Artefact;

import java.math.BigInteger;

public interface  ConveyerDataReader {
    public Artefact read(BigInteger id);
}
