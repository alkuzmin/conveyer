package ru.kuzmin.conveyer.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuzmin.conveyer.entities.Artefact;

import java.math.BigInteger;


@Repository
public interface ArtefactRepo extends JpaRepository<Artefact, BigInteger> {
}
