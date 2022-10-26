package org.sitrack.sopaletras;

import org.sitrack.sopaletras.repository.impl.CustomMongoRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(repositoryBaseClass = CustomMongoRepositoryImpl.class)

public class MsSopaLetrasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSopaLetrasApplication.class, args);
	}

}
