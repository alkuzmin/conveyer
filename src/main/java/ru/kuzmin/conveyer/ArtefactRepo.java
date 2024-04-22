package ru.kuzmin.conveyer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;


@Repository
public interface ArtefactRepo extends JpaRepository<Artefact, BigInteger> {
}
