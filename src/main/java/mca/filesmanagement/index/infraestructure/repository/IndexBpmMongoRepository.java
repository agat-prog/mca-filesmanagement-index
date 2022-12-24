package mca.filesmanagement.index.infraestructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import mca.filesmanagement.index.infraestructure.model.IndexBpmDocument;

public interface IndexBpmMongoRepository extends MongoRepository<IndexBpmDocument, String>{
}
