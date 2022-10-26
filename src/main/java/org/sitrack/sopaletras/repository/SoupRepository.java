package org.sitrack.sopaletras.repository;


import java.util.List;
import java.util.UUID;

import org.sitrack.sopaletras.model.SoapEntityExtend;
import org.sitrack.sopaletras.model.SoupEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SoupRepository extends MongoRepository<SoapEntityExtend, UUID> {
	
	 

}
