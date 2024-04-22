package ru.kuzmin.conveyer;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.kuzmin.conveyer.datareaders.ReaderFromFile;
import ru.kuzmin.conveyer.datawriters.WriterToFile;
import ru.kuzmin.conveyer.entities.Artefact;
import ru.kuzmin.conveyer.repos.ArtefactRepo;
import ru.kuzmin.conveyer.services.ArtefactService;

import java.math.BigInteger;
import java.util.Optional;


@SpringBootApplication(scanBasePackages = "ru.kuzmin.conveyer")
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {ru.kuzmin.conveyer.services.ArtefactService.class, ru.kuzmin.conveyer.repos.ArtefactRepo.class})
@Testcontainers
class ConveyerApplicationTests {

	@Container
	static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine")
			.withDatabaseName("jpadb")
			.withUsername("jpa")
			.withPassword("postgres")
			/*.withCopyFileToContainer(MountableFile.forHostPath("schema.sql"),
                "/docker-entrypoint-initdb.d/"
			)*/;

	@BeforeAll
	static void beforeAll() {
		postgres.start();
	}

	@AfterAll
	static void afterAll() {
		postgres.stop();
	}

	@DynamicPropertySource
	static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", postgres::getJdbcUrl);
		registry.add("spring.datasource.name", postgres::getUsername);
		registry.add("spring.datasource.password", postgres::getPassword);
	}
	@Test
	void contextLoads(ApplicationContext context) {
		Assertions.assertNotNull(context);
	}

	@Test
	void pgContainerIsUp()
	{
		Assertions.assertEquals("running", postgres.getContainerInfo().getState().getStatus());
	}

	@Test
	void shouldCreateArtefact(ApplicationContext context, @Autowired ArtefactService serv)
	{
		Artefact res = serv.saveArtefact(new Artefact("testArt1"));
		//System.out.println(res.getId());
		Integer id = res.getId();

		Optional<Artefact> res2 = serv.getArtefactbyId(BigInteger.valueOf(id));
		if (res2.isPresent())
		{Assertions.assertEquals("testArt1",res2.get().getName());}
		else
		{Assertions.fail("No res from db");}
	}

}
