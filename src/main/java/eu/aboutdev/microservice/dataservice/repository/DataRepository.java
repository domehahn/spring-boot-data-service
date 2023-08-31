package eu.aboutdev.microservice.dataservice.repository;

import eu.aboutdev.microservice.dataservice.model.Data;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends MongoRepository<Data, String> {
}
