package org.sitrack.sopaletras.repository;

import java.util.UUID;

import org.sitrack.sopaletras.model.SoupEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomMongoRepository<T extends SoupEntity> extends MongoRepository<T, UUID> {

}
